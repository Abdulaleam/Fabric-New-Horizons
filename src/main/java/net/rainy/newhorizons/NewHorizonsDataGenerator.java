package net.rainy.newhorizons;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.rainy.newhorizons.datagen.ModBlockLootTableProvider;
import net.rainy.newhorizons.datagen.ModBlockTagProvider;
import net.rainy.newhorizons.datagen.ModModelProvider;
import net.rainy.newhorizons.datagen.ModRecipeProvider;

public class NewHorizonsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
     var pack = fabricDataGenerator.createPack();

	 pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);

	}
}
