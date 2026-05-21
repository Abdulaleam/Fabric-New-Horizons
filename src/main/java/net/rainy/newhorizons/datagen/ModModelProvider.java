package net.rainy.newhorizons.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.rainy.newhorizons.Item_package.mah_item;
import net.rainy.newhorizons.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.BASKOTA_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.COOKED_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.BURNT_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.BASKOTAFRENDO_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.SAMIR_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.HOQA_BLOCK);
        // Lol added my friends as fun
        // What is minecraft without friends?


    }
// My lovely page that i wasted 30 mins not knwoing the error
    // turns out i had added the same item twice SIGH . FIXED
    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
      itemModelGenerators.generateFlatItem(mah_item.BASKOTA_RAW, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.BASKOTA_COOKED, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.BASKOTA_BURNT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.BASKOTA_FRENDO, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.SAMIR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.CRUSHEDOXIDIZED_IRON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.OXIDIZEDIRON_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.REDUCED_IRON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.HYDROGEN_GAS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.MagicNyaa, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.TREE_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(mah_item.STONE_DUST, ModelTemplates.FLAT_ITEM);
        // I feel too evil rn , IT takes ages to get iron now.

    }
}
