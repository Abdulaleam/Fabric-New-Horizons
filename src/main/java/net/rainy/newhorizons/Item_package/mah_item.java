package net.rainy.newhorizons.Item_package;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.rainy.newhorizons.NewHorizons;

import java.util.function.Function;

public class mah_item {
    public static  final Item BASKOTA_RAW = registerItem("baskota_raw", Item::new);
    public static  final Item BASKOTA_COOKED = registerItem("baskota_cooked", Item::new);
    public static  final Item BASKOTA_BURNT = registerItem("baskota_burnt", Item::new);
    public static  final Item BASKOTA_FRENDO = registerItem("baskota_frendo", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name)))));
    }

    public static void registerModItem() {
        NewHorizons.LOGGER.info("Registering Modded Items i guess for " +NewHorizons.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(BASKOTA_RAW);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output -> {
            output.accept(BASKOTA_COOKED);
            output.accept(BASKOTA_BURNT);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BASKOTA_FRENDO);
        });
    }


}