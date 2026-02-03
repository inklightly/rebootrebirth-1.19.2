package com.rebootrebirth.mod.mixin;

import com.rebootrebirth.mod.util.BrewingPatchLogger;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Mixin(value = BrewingRecipeRegistry.class, remap = false)
public abstract class BrewingRecipeSyncMixin {

    @Shadow @Final @Mutable
    private static List<IBrewingRecipe> recipes;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void rebootrebirth$wrapRecipesList(CallbackInfo ci) {
        // Make iteration safe even if mods add recipes from parallel setup threads.
        if (!(recipes instanceof CopyOnWriteArrayList)) {
            recipes = new CopyOnWriteArrayList<>(recipes);
        }
    }

    @Inject(
            method = "addRecipe(Lnet/minecraftforge/common/brewing/IBrewingRecipe;)Z",
            at = @At("HEAD")
    )
    private static void rebootrebirth$logAddRecipe(IBrewingRecipe recipe, CallbackInfoReturnable<Boolean> cir) {
        BrewingPatchLogger.logAddRecipeUseOnce();
    }

    @Inject(
            method = "addRecipe(Lnet/minecraft/world/item/crafting/Ingredient;Lnet/minecraft/world/item/crafting/Ingredient;Lnet/minecraft/world/item/ItemStack;)Z",
            at = @At("HEAD")
    )
    private static void rebootrebirth$logAddRecipeIngredients(
            net.minecraft.world.item.crafting.Ingredient input,
            net.minecraft.world.item.crafting.Ingredient ingredient,
            net.minecraft.world.item.ItemStack output,
            CallbackInfoReturnable<Boolean> cir
    ) {
        BrewingPatchLogger.logAddRecipeUseOnce();
    }
}
