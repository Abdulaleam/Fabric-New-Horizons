package net.rainy.newhorizons.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.rainy.newhorizons.NewHorizons;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.rainy.newhorizons.block.custom.Crusher;
import net.rainy.newhorizons.block.custom.Reducer;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
     public static final Block BASKOTA_BLOCK = registerBlock("baskota_block",
             properties -> new Block(properties.strength(4f)
                     .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final Block HOQA_BLOCK = registerBlock("hoka_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

     public static final Block COOKED_BLOCK = registerBlock("cooked_block",
             properties -> new Block(properties.strength(4f)
                     .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), Component.translatable("tooltip.mahmod.perfectfood"));

     public static final Block BURNT_BLOCK = registerBlock("burnt_block",
             properties -> new Block(properties.strength(4f)
                     .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

     public static final Block REDUCER = registerBlock("reducer",
             properties -> new Reducer(properties.strength(4f)
                     .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
     public static final Block CRUSHER = registerBlock("crusher",
             properties -> new Crusher(properties.strength(4f)
                     .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));

    public static final Block BASKOTAFRENDO_BLOCK = registerBlock("baskotafrendo_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), Component.translatable("tooltip.mahmod.baskotafriend"));
    public static final Block SAMIR_BLOCK = registerBlock("samir_block",
            properties -> new Block(properties.strength(0.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)
                    .lightLevel(state -> 10)
                    .ignitedByLava()
                    .friction(7f)), Component.translatable("tooltip.mahmod.samirfriend"));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name), toRegister);
    }


    private static void registerBlockItem(String name, Block block){
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name)))));


    }
  private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, Component...tooltips) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name))));
        registerBlockItem(name, toRegister, tooltips);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name), toRegister);
    }


    private static void registerBlockItem(String name, Block block, Component... tooltips){
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NewHorizons.MOD_ID, name)))){
                    @Override
                    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                        for (var component : tooltips){
                            builder.accept(component);
                        }
                        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                    }
                });


    }


    public static void registerModBlocks(){

        NewHorizons.LOGGER.info("Registering Mod Blocks for"+ NewHorizons.MOD_ID);
    }



}
