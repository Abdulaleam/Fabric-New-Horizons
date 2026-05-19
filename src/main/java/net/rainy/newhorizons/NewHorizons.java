package net.rainy.newhorizons;

import net.fabricmc.api.ModInitializer;

import net.rainy.newhorizons.Item_package.mah_item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewHorizons implements ModInitializer {
	public static final String MOD_ID = "new-horizons";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override 
	public void onInitialize() {
	mah_item.registerModItem();

	}
}