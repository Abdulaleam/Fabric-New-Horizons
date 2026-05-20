package net.rainy.newhorizons.creativemodtab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.rainy.newhorizons.Item_package.mah_item;
import net.rainy.newhorizons.NewHorizons;
import net.minecraft.core.registries.BuiltInRegistries;
import net.rainy.newhorizons.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final CreativeModeTab NEW_HORIZONS_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, "new_horizons_items"),
            FabricCreativeModeTab.builder().icon(()-> new ItemStack(mah_item.BASKOTA_RAW))
                    .title(Component.translatable("creativemodetab.newhorizons.newhorizons_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(mah_item.BASKOTA_RAW);
                        output.accept(mah_item.BASKOTA_COOKED);
                        output.accept(mah_item.BASKOTA_BURNT);
                        output.accept(mah_item.BASKOTA_FRENDO);
                        output.accept(ModBlocks.BASKOTA_BLOCK);


                    })



                    .build());

    public static final CreativeModeTab NEW_HORIZONS_FRIENDS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, "new_horizons_friends"),
            FabricCreativeModeTab.builder().icon(()-> new ItemStack(mah_item.BASKOTA_FRENDO))
                    .title(Component.translatable("creativemodetab.newhorizons.newhorizons_friends"))
                    .displayItems((parameters, output) -> {
                        output.accept(mah_item.BASKOTA_FRENDO);


                    })



                    .build());

    public static void registerModCreativeModeTabs() {
        NewHorizons.LOGGER.info("Registering Creative Mode Tabs for "+ NewHorizons.MOD_ID);


    }
}
