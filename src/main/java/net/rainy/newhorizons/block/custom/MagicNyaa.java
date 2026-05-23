package net.rainy.newhorizons.block.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.rainy.newhorizons.block.ModBlocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MagicNyaa extends Item {

    private static final Map<Block, Block> MAGIC_MAP = new HashMap<>();

    static {
        for (Block block : BuiltInRegistries.BLOCK) {
            MAGIC_MAP.put(block, ModBlocks.COOKED_BLOCK);
        }

        MAGIC_MAP.put(ModBlocks.COOKED_BLOCK, ModBlocks.BURNT_BLOCK);
    }

    public MagicNyaa(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        // Right Click Block to COOKIFY IT ima make everrything a cookie
        // IT WILL MAKE IT A COOKIE hehe raIny

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(MAGIC_MAP.containsKey(clickedBlock) && !level.isClientSide()) {
            // do i have to make this server sided? idk
            level.setBlockAndUpdate(context.getClickedPos(),
                    MAGIC_MAP.get(clickedBlock).defaultBlockState());

            context.getItemInHand().hurtAndBreak(1,
                    context.getPlayer(),
                    context.getHand());
        }

        return InteractionResult.SUCCESS;

    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if (Minecraft.getInstance().hasShiftDown()){
            builder.accept(Component.translatable("tooltip.new-horizons.magicnyaa.shift_down"));

        }else {
            builder.accept(Component.translatable("tooltip.new-horizons.magicnyaa"));

        }


        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}