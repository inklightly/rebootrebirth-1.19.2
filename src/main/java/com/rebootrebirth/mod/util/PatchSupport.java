package com.rebootrebirth.mod.util;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class PatchSupport {
    private PatchSupport() {}

    // patchName -> lock object
    private static final ConcurrentHashMap<String, Object> LOCKS = new ConcurrentHashMap<>();

    // dedupe key set (patchName + resolved identity)
    static final Set<String> LOG_ONCE = ConcurrentHashMap.newKeySet();

    public static Object lock(String patchName) {
        return LOCKS.computeIfAbsent(patchName, k -> new Object());
    }
}
