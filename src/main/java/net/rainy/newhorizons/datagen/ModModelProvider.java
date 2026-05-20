package net.rainy.newhorizons.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.rainy.newhorizons.Item_package.mah_item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
      itemModelGenerators.generateFlatItem(mah_item.BASKOTA_RAW, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.BASKOTA_COOKED, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.BASKOTA_BURNT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.BASKOTA_FRENDO, ModelTemplates.FLAT_ITEM);
    }
}
