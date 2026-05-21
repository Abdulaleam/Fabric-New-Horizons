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
                List<ItemLike> NewV3_SMELTABLES = List.of(Items.POTION);
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
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS,mah_item.BASKOTA_RAW, RecipeCategory.DECORATIONS, ModBlocks.BASKOTA_BLOCK);
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
                shaped(RecipeCategory.MISC, Items.OAK_WOOD)
                        .pattern("RR")
                        .pattern("RR")
                        .define('R', mah_item.TREE_BARK)
                        .unlockedBy(getHasName(mah_item.OXIDIZEDIRON_DUST),has(mah_item.CRUSHEDOXIDIZED_IRON))
                        .group("horizons")
                        .save(output,"uhh_oak_but_harder");
                shaped(RecipeCategory.MISC, Items.COBBLESTONE)
                        .pattern("RR")
                        .pattern("RR")
                        .define('R', mah_item.STONE_DUST)
                        .unlockedBy(getHasName(mah_item.OXIDIZEDIRON_DUST),has(mah_item.CRUSHEDOXIDIZED_IRON))
                        .group("horizons")
                        .save(output,"uhh_stone_but_harder");
                  shapeless(RecipeCategory.MISC,mah_item.SAMIR,9)
                          .requires(ModBlocks.SAMIR_BLOCK)
                          .unlockedBy(getHasName(mah_item.SAMIR),has(ModBlocks.SAMIR_BLOCK))
                          .group("horizons")
                          .save(output, "second_recipe_hehehe");
                shapeless(RecipeCategory.MISC,mah_item.BASKOTA_COOKED,9)
                        .requires(ModBlocks.COOKED_BLOCK)
                        .unlockedBy(getHasName(mah_item.BASKOTA_COOKED),has(ModBlocks.COOKED_BLOCK))
                        .group("horizons")
                        .save(output, "recipe_3_brh_im_tired");
                shapeless(RecipeCategory.MISC,mah_item.BASKOTA_BURNT,9)
                        .requires(ModBlocks.BURNT_BLOCK)
                        .unlockedBy(getHasName(mah_item.OXIDIZEDIRON_DUST),has(mah_item.CRUSHEDOXIDIZED_IRON))
                        .group("horizons")
                        .save(output, "recipe_4_im_happy");
                shapeless(RecipeCategory.MISC,mah_item.BASKOTA_RAW,9)
                        .requires(ModBlocks.BASKOTA_BLOCK)
                        .unlockedBy(getHasName(mah_item.OXIDIZEDIRON_DUST),has(mah_item.CRUSHEDOXIDIZED_IRON))
                        .group("horizons")
                        .save(output, "recipe_5_will_i_need_this_name_later_");
            }
        };
    }

    @Override
    public String getName() {
        return "New Horizons Recipes";
    }
}
