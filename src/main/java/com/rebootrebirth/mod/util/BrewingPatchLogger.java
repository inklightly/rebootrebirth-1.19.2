package com.rebootrebirth.mod.util;

public final class BrewingPatchLogger {
    private BrewingPatchLogger() {}

    public static void logAddRecipeUseOnce() {
        PatchLogger.logUseOnce("addRecipe");
    }
}
