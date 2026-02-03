package com.rebootrebirth.mod.mixin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class RebootRebirthMixinPlugin implements IMixinConfigPlugin {

    private static final Logger LOGGER = LogManager.getLogger("rebootrebirth-mixin");

    private static String simpleName(String className) {
        int lastDot = className.lastIndexOf('.');
        return (lastDot >= 0) ? className.substring(lastDot + 1) : className;
    }

    @Override
    public void onLoad(String mixinPackage) {
        LOGGER.info("[RebootRebirth] Mixin plugin loaded for package: {}", mixinPackage);
    }

    @Override public String getRefMapperConfig() { return null; }
    @Override public boolean shouldApplyMixin(String targetClassName, String mixinClassName) { return true; }
    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        LOGGER.info("[RebootRebirth] Applied {} -> {}", simpleName(mixinClassName), targetClassName);
    }
}
