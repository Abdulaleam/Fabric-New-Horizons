package net.rainy.newhorizons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.rainy.newhorizons.Item_package.mah_item;
import net.rainy.newhorizons.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.SAMIR_BLOCK);
        dropSelf(ModBlocks.HOQA_BLOCK);

        add(ModBlocks.BASKOTA_BLOCK, createOreDrop(ModBlocks.BASKOTA_BLOCK, mah_item.BASKOTA_RAW));
        add(ModBlocks.COOKED_BLOCK, createOreDrop(ModBlocks.COOKED_BLOCK, mah_item.BASKOTA_COOKED));
        add(ModBlocks.BURNT_BLOCK, createOreDrop(ModBlocks.BURNT_BLOCK, mah_item.BASKOTA_BURNT));
        add(ModBlocks.SAMIR_BLOCK, createOreDrop(ModBlocks.SAMIR_BLOCK, mah_item.SAMIR));
    }
        public LootTable.Builder createMultipleOreDrops(final Block block, Item item , float minDrops, float maxDrops) {
            HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

            return this.createSilkTouchDispatchTable(
                    block, this.applyExplosionDecay(
                            block,LootItem.lootTableItem(item)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                    .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                    )
            );
        }




    }

