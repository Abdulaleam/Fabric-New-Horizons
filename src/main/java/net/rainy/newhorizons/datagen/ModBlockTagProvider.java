package net.rainy.newhorizons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.rainy.newhorizons.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BURNT_BLOCK)
                .add(ModBlocks.SAMIR_BLOCK)
                .add(ModBlocks.HOQA_BLOCK)
                .add(ModBlocks.BASKOTAFRENDO_BLOCK)
                .add(ModBlocks.COOKED_BLOCK)
                .add(ModBlocks.BASKOTA_BLOCK);
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAMIR_BLOCK);


    }
}
