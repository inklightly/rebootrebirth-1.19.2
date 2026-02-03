package com.rebootrebirth.mod.util;

import com.rebootrebirth.mod.RebootRebirthMod;

public final class PatchLogger {
    private PatchLogger() {}

    /**
     * Logs once per (patchName + jar label).
     */
    public static void logUseOnce(String patchName) {
        CallerModResolver.CallerInfo ci = CallerModResolver.findCallingModInfo();

        // Dedupe by jar label (most useful + stable for your current "union:" situation)
        String whoKey = ci.jarLabel();
        String key = patchName + "|" + whoKey;

        if (PatchSupport.LOG_ONCE.add(key)) {
            RebootRebirthMod.LOGGER.info("[RebootRebirth] {} used by {}", patchName, whoKey);
        }
    }
}
