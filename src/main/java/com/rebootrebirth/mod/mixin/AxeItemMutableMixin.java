package com.rebootrebirth.mod.mixin;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(AxeItem.class)
public class AxeItemMutableMixin {
    @Shadow @Final @Mutable
    private static Map<Block, Block> STRIPPABLES;
}
