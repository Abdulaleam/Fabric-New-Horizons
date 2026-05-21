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
import net.rainy.newhorizons.block.custom.MagicNyaa;
import net.rainy.newhorizons.food.ModFoods;

import java.util.function.Function;

public class mah_item {
    public static  final Item BASKOTA_RAW = registerItem("baskota_raw", Item::new);
    public static  final Item BASKOTA_COOKED = registerItem("baskota_cooked", properties -> new Item(properties.food( ModFoods.BASKOTA_RAW,ModFoods.BASKOTA_COOKED)));
    public static  final Item BASKOTA_BURNT = registerItem("baskota_burnt", properties -> new Item(properties.food(ModFoods.BASKOTA_RAW,ModFoods.BASKOTA_BURNT)));
    public static  final Item BASKOTA_FRENDO = registerItem("baskota_frendo", Item::new);
    public static  final Item SAMIR = registerItem("samir", Item::new);
    public static  final Item CRUSHEDOXIDIZED_IRON = registerItem("crushedoxidized_iron", Item::new);
    public static  final Item OXIDIZEDIRON_DUST = registerItem("oxidizediron_dust", Item::new);
    public static  final Item REDUCED_IRON = registerItem("reduced_iron", Item::new);
    public static  final Item HYDROGEN_GAS = registerItem("hydrogen_gas", Item::new);
    public static  final Item TREE_BARK = registerItem("tree_bark", Item::new);
    public static  final Item STONE_DUST = registerItem("stone_dust", Item::new);
    public static final Item MagicNyaa = registerItem("magicnyaa",(properties -> new MagicNyaa(properties.durability(64))));


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name)))));
    }

    public static void registerModItem() {
        NewHorizons.LOGGER.info("Registering Modded Items i guess for " +NewHorizons.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(BASKOTA_RAW);
            output.accept(CRUSHEDOXIDIZED_IRON);
            output.accept(OXIDIZEDIRON_DUST);
            output.accept(REDUCED_IRON);
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