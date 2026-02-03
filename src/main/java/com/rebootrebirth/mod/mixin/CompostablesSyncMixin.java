package com.rebootrebirth.mod.mixin;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatMaps;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ComposterBlock.class)
public abstract class CompostablesSyncMixin {

    @Shadow @Final @Mutable
    private static Object2FloatMap<ItemLike> COMPOSTABLES;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void rebootrebirth$wrapCompostablesMap(CallbackInfo ci) {
        // Wrap the map so ALL put/get/remove/etc are synchronized.
        COMPOSTABLES = Object2FloatMaps.synchronize(
                new com.rebootrebirth.mod.util.LoggingCompostablesMap(COMPOSTABLES)
        );
    }
}
