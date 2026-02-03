package com.rebootrebirth.mod.util;

import net.minecraftforge.forgespi.language.IModInfo;
import net.minecraftforge.fml.ModList;

import java.util.Locale;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CallerModResolver {

    public static final class CallerInfo {
        public final String modId;        // "vinery" or "unknown"
        public final String reason;       // why unknown
        public final String callerClass;  // first non-ignored stack class
        public final String codeSource;   // URL string (best effort)
        public final String jarPath;      // normalized path (best effort)
        public String displayName() {
            if (!isUnknown()) return modId;
            return CallerModResolver.groupFromCallerClass(callerClass);
        }

        public String jarLabel() {
            // Prefer the jar filename pulled from CodeSource (works with union:/...).
            String jar = CallerModResolver.extractJarName(codeSource);
            if (jar != null) return jar;

            // Fallback: if we did get a real filesystem path, use its filename.
            if (jarPath != null) {
                try {
                    return java.nio.file.Paths.get(jarPath).getFileName().toString();
                } catch (Throwable ignored) {}
            }

            // Last resort: the caller class (still more useful than "unknown")
            return callerClass;
        }

        public CallerInfo(String modId, String reason, String callerClass, String codeSource, String jarPath) {
            this.modId = modId;
            this.reason = reason;
            this.callerClass = callerClass;
            this.codeSource = codeSource;
            this.jarPath = jarPath;
        }

        public boolean isUnknown() {
            return "unknown".equals(modId);
        }

        public String pretty() {
            if (!isUnknown()) return modId;
            return "unknown (reason=" + reason
                    + ", caller=" + callerClass
                    + ", src=" + codeSource
                    + (jarPath != null ? ", jar=" + jarPath : "")
                    + ")";
        }
    }

    private static volatile boolean initialized = false;

    // absolutePathString -> "modid" or "modid1,modid2"
    private static final Map<String, String> jarPathToModIds = new ConcurrentHashMap<>();

    // jarFileName -> "modid" or "modid1,modid2"
    private static final Map<String, String> jarNameToModIds = new ConcurrentHashMap<>();

    // Packages to ignore when looking for the "real" caller
    private static final String[] IGNORE_PREFIXES = new String[] {
            "com.rebootrebirth.",
            "dev.architectury.",
            "net.minecraft.",
            "net.minecraftforge.",
            "org.spongepowered.",
            "java.",
            "sun.",
            "it.unimi.dsi.fastutil."
    };

    private CallerModResolver() {}

    private static void ensureInit() {
        if (initialized) return;
        synchronized (CallerModResolver.class) {
            if (initialized) return;

            // Forge not ready yet — don't die, just leave map empty for now.
            if (net.minecraftforge.fml.ModList.get() == null) {
                return;
            }

            for (net.minecraftforge.forgespi.language.IModInfo info : net.minecraftforge.fml.ModList.get().getMods()) {
                try {
                    java.nio.file.Path p = info.getOwningFile().getFile().getFilePath()
                            .toAbsolutePath().normalize();
                    String key = p.toString();
                    String modId = info.getModId();

                    jarPathToModIds.merge(key, modId, (a, b) -> a.contains(b) ? a : (a + "," + b));

                    // NEW: also map jar filename -> modid (for union:/... codesource cases)
                    String jarFileName = p.getFileName().toString().toLowerCase(Locale.ROOT);
                    jarNameToModIds.merge(jarFileName, modId, (a, b) -> a.contains(b) ? a : (a + "," + b));

                } catch (Throwable ignored) {}
            }

            initialized = true;
        }
    }

    private static String groupFromCallerClass(String callerClassName) {
        if (callerClassName == null || callerClassName.equals("n/a")) return "unknown";

        int lastDot = callerClassName.lastIndexOf('.');
        if (lastDot <= 0) return callerClassName;

        String pkg = callerClassName.substring(0, lastDot); // drop the class name
        String[] parts = pkg.split("\\.");
        if (parts.length == 0) return "unknown";

        // Heuristics:
        // - net.mcreator.<mod>  -> 3 segments
        // - satisfy.<mod> / satisfyu.<mod> -> 2 segments
        // - default -> 3 segments (works well for com.alexander.mutantmore, com.obscuria.aquamirae, etc.)
        int depth = 3;

        if (parts[0].equals("net") && parts.length >= 2 && parts[1].equals("mcreator")) {
            depth = 3;
        } else if (parts[0].equals("satisfy") || parts[0].equals("satisfyu")) {
            depth = 2;
        }

        depth = Math.min(depth, parts.length);

        StringBuilder sb = new StringBuilder(parts[0]);
        for (int i = 1; i < depth; i++) sb.append('.').append(parts[i]);
        return sb.toString();
    }

    private static boolean ignored(String className) {
        for (String p : IGNORE_PREFIXES) {
            if (className.startsWith(p)) return true;
        }
        return false;
    }

    private static Path urlToPath(URL url) {
        try {
            URI uri = url.toURI();

            // Handle "jar:file:...!/..."
            if ("jar".equals(uri.getScheme())) {
                String s = uri.toString();
                int bang = s.indexOf('!');
                if (bang > 0) {
                    uri = URI.create(s.substring(4, bang)); // strip "jar:" and everything after "!"
                }
            }

            // NOTE: union: URLs from ModLauncher often won't convert cleanly to a Path.
            // We'll still try; if it fails, our jar-name fallback handles it.
            return Paths.get(uri).toAbsolutePath().normalize();
        } catch (Throwable t) {
            return null;
        }
    }

    private static String extractJarName(String codeSourceStr) {
        if (codeSourceStr == null) return null;

        String s = codeSourceStr;

        // Drop everything after "!/" (jar/union style)
        int bang = s.indexOf("!/");
        if (bang >= 0) s = s.substring(0, bang);

        // Last path segment
        int slash = Math.max(s.lastIndexOf('/'), s.lastIndexOf('\\'));
        if (slash >= 0 && slash + 1 < s.length()) s = s.substring(slash + 1);

        // Decode %20, %23, etc (ModLauncher uses %23 for '#')
        try {
            s = URLDecoder.decode(s, StandardCharsets.UTF_8);
        } catch (Throwable ignored) {}

        // Keep only up to ".jar"
        String lower = s.toLowerCase(Locale.ROOT);
        int jarIdx = lower.indexOf(".jar");
        if (jarIdx < 0) return null;

        String jarName = s.substring(0, jarIdx + 4);
        return jarName;
    }

    public static CallerInfo findCallingModInfo() {
        ensureInit();

        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        for (StackTraceElement el : st) {
            String cn = el.getClassName();
            if (ignored(cn)) continue;

            String codeSourceStr = "null";
            String jarPathStr = null;

            try {
                Class<?> cls = Class.forName(cn, false, CallerModResolver.class.getClassLoader());
                java.security.CodeSource cs = cls.getProtectionDomain().getCodeSource();

                if (cs == null || cs.getLocation() == null) {
                    return new CallerInfo("unknown", "no_codesource", cn, codeSourceStr, null);
                }

                codeSourceStr = cs.getLocation().toString();

                Path p = urlToPath(cs.getLocation());
                if (p != null) {
                    jarPathStr = p.toString();
                    String modIds = jarPathToModIds.get(jarPathStr);
                    if (modIds != null) {
                        return new CallerInfo(modIds, "ok_path", cn, codeSourceStr, jarPathStr);
                    }
                }

                // Fallback for ModLauncher "union:" URLs: resolve by jar filename
                String jarName = extractJarName(codeSourceStr);
                if (jarName != null) {
                    String jarKey = jarName.toLowerCase(Locale.ROOT);

                    String byName = jarNameToModIds.get(jarKey);

                    if (byName != null) {
                        return new CallerInfo(byName, "ok_jarname", cn, codeSourceStr, jarPathStr);
                    }
                    return new CallerInfo("unknown", "jarname_not_in_modlist_map", cn, codeSourceStr, jarPathStr);
                }

                return new CallerInfo("unknown", "jar_not_in_modlist_map", cn, codeSourceStr, jarPathStr);
            } catch (ClassNotFoundException e) {
                return new CallerInfo("unknown", "class_not_found", cn, codeSourceStr, jarPathStr);
            } catch (Throwable t) {
                return new CallerInfo("unknown", "exception:" + t.getClass().getSimpleName(), cn, codeSourceStr, jarPathStr);
            }
        }

        return new CallerInfo("unknown", "no_nonignored_stack_frame", "n/a", "n/a", null);
    }
}
