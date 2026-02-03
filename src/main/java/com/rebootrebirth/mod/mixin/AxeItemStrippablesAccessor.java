package com.rebootrebirth.mod.mixin;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(AxeItem.class)
public interface AxeItemStrippablesAccessor {

    @Accessor("STRIPPABLES")
    static Map<Block, Block> rebootrebirth$getStrippables() {
        throw new AssertionError();
    }

    @Accessor("STRIPPABLES")
    static void rebootrebirth$setStrippables(Map<Block, Block> map) {
        throw new AssertionError();
    }
}
