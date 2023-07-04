package com.stratecide.nerf_bone_meal.mixin;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.BambooSaplingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CocoaBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.FungusBlock;
import net.minecraft.block.KelpBlock;
import net.minecraft.block.KelpPlantBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoneMealItem.class)
public class BoneMealItemMixin {
	@Inject(at = @At("HEAD"), method = "useOnFertilizable", cancellable = true)
	private static void useOnFertilizableInject(ItemStack stack, World world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		BlockState blockState = world.getBlockState(pos);
		Block block = blockState.getBlock();
		if (
			block instanceof BambooBlock || block instanceof BambooSaplingBlock
			|| block instanceof CocoaBlock
			|| block instanceof CropBlock
			|| block instanceof FungusBlock
			|| block instanceof KelpBlock || block instanceof KelpPlantBlock
			|| block instanceof SaplingBlock
			|| block instanceof StemBlock
			|| block instanceof SweetBerryBushBlock
		) {
		  	cir.setReturnValue(false);
		}
	}
}