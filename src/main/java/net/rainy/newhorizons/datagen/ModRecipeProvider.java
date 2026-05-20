package net.rainy.newhorizons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;
import net.rainy.newhorizons.Item_package.mah_item;
import net.rainy.newhorizons.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries,output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> New_SMELTABLES = List.of(mah_item.BASKOTA_FRENDO, mah_item.BASKOTA_RAW,
                        mah_item.SAMIR);
                List<ItemLike> NewV3_SMELTABLES = List.of(Items.WATER_BUCKET);
                List<ItemLike> NewV4_SMELTABLES = List.of(mah_item.BASKOTA_COOKED);
                List<ItemLike> NewV2_SMELTABLES = List.of(mah_item.REDUCED_IRON);
                oreSmelting(NewV3_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, mah_item.HYDROGEN_GAS,0.25F,50, "horizons");
                oreBlasting(NewV3_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, mah_item.HYDROGEN_GAS,0.25F,50, "horizons");
                oreSmelting(NewV4_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, mah_item.BASKOTA_BURNT,0.25F,50, "horizons");
                oreBlasting(NewV4_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, mah_item.BASKOTA_BURNT,0.25F,50, "horizons");
                oreSmelting(NewV2_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.IRON_INGOT,0.25F,50, "horizons");
                oreBlasting(NewV2_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.IRON_INGOT,0.25F,50, "horizons");
                oreBlasting(New_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, mah_item.BASKOTA_COOKED,0.25F,50, "horizons");
                oreSmelting(New_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, mah_item.BASKOTA_COOKED,0.25F,50, "horizons");
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS,mah_item.BASKOTA_COOKED, RecipeCategory.DECORATIONS, ModBlocks.COOKED_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS,mah_item.SAMIR, RecipeCategory.DECORATIONS, ModBlocks.SAMIR_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS,mah_item.BASKOTA_BURNT, RecipeCategory.DECORATIONS, ModBlocks.BURNT_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS,mah_item.CRUSHEDOXIDIZED_IRON, RecipeCategory.DECORATIONS, mah_item.OXIDIZEDIRON_DUST);
              shaped(RecipeCategory.MISC, mah_item.REDUCED_IRON)
                      .pattern("RRR")
                      .pattern("RFR")
                      .pattern("RRR")
                      .define('R', mah_item.OXIDIZEDIRON_DUST)
                      .define('F', mah_item.HYDROGEN_GAS)
                      .unlockedBy(getHasName(mah_item.OXIDIZEDIRON_DUST),has(mah_item.CRUSHEDOXIDIZED_IRON))
                      .group("horizons")
                      .save(output);
                  shapeless(RecipeCategory.MISC,mah_item.CRUSHEDOXIDIZED_IRON,9)
                          .requires(mah_item.OXIDIZEDIRON_DUST)
                          .unlockedBy(getHasName(mah_item.OXIDIZEDIRON_DUST),has(mah_item.CRUSHEDOXIDIZED_IRON))
                          .group("horizons")
                          .save(output, "iron_fromandrecipe_stick");
            }
        };
    }

    @Override
    public String getName() {
        return "New Horizons Recipes";
    }
}
