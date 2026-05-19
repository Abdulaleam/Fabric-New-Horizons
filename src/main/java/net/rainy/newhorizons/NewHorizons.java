package net.rainy.newhorizons;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.rainy.newhorizons.Item_package.mah_item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.Function;

public class NewHorizons implements ModInitializer {
  public static  final	Item BASKOTA = registerItem("Baskota", properties -> new Item(properties))

	private static Item registerItem(String name, Function<Item.Properties, Item> function) {
		 return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name),
				 function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name)))));
	}
	public static final String MOD_ID = "new-horizons";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override 
	public void onInitialize() {

		mah_item.registerModItem();
	}
}