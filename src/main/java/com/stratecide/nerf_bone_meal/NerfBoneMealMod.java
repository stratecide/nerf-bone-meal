package com.stratecide.nerf_bone_meal;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NerfBoneMealMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nerf-bone-meal");

	@Override
	public void onInitialize() {
		// prevent fully-automatic Moss + Bone Meal farm
		// in vanilla, one Bone Meal can be turned into (up to) three according to
		// https://minecraft.fandom.com/wiki/Tutorials/Bone_meal_farming#Moss-based_automatic_bone_meal_farm
        nerfComposting(Items.AZALEA);
        nerfComposting(Items.FLOWERING_AZALEA);
        nerfComposting(Items.MOSS_CARPET);
        nerfComposting(Items.MOSS_BLOCK);
        nerfComposting(Items.WHEAT_SEEDS);
	}

	private static void nerfComposting(ItemConvertible itemToNerf) {
		ItemConvertible item = (ItemConvertible) itemToNerf.asItem();
		float old = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(item);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(item, old / 3.f);
	}
}