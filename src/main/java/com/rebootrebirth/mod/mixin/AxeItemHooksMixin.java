package com.rebootrebirth.mod.mixin;

import com.rebootrebirth.mod.util.PatchLogger;
import com.rebootrebirth.mod.util.PatchSupport;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;

import java.util.HashMap;
import java.util.Map;

@Pseudo
@Mixin(targets = "dev.architectury.hooks.item.tool.AxeItemHooks", remap = false)
public class AxeItemHooksMixin {

    /**
     * @author inklightly
     * @reason Forge can run common_setup work in parallel; Architectury's addStrippable copies STRIPPABLES
     *         while other threads may mutate it, causing ConcurrentModificationException during mod loading.
     *         Serialize updates and replace STRIPPABLES atomically to prevent crashes.
     */
    @Overwrite
    public static void addStrippable(Block input, Block result) {
        if (!input.defaultBlockState().hasProperty(BlockStateProperties.AXIS)
                || !result.defaultBlockState().hasProperty(BlockStateProperties.AXIS)) {
            throw new IllegalArgumentException("Strippable blocks must have the AXIS property: "
                    + input + " -> " + result);
        }

        synchronized (PatchSupport.lock("axe.addStrippable")) {
            PatchLogger.logUseOnce("axe.addStrippable");

            Map<Block, Block> current = AxeItemStrippablesAccessor.rebootrebirth$getStrippables();
            Map<Block, Block> copy = new HashMap<>(current);
            copy.put(input, result);
            AxeItemStrippablesAccessor.rebootrebirth$setStrippables(copy);
        }
    }
}
