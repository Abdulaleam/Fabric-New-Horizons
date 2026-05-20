package net.rainy.newhorizons.block.custom;
import net.rainy.newhorizons.block.ModBlocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class MagicNyaa extends Item {
    private static final Map<Block, Block> MAGIC_MAP =
            Map.of(
                    ModBlocks.SAMIR_BLOCK, ModBlocks.COOKED_BLOCK,
                    ModBlocks.BASKOTA_BLOCK, ModBlocks.COOKED_BLOCK,
                    Blocks.OAK_LOG,ModBlocks.COOKED_BLOCK,
                    ModBlocks.COOKED_BLOCK, ModBlocks.BURNT_BLOCK,
                    Blocks.STONE, ModBlocks.COOKED_BLOCK,
                    Blocks.DIRT, ModBlocks.COOKED_BLOCK

            );

    public MagicNyaa(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        // Right Click Block
        // IT WILL MAKE IT A COOKIE hehe raIny

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(MAGIC_MAP.containsKey(clickedBlock) && !level.isClientSide()) {
            // We are on the Server!
            level.setBlockAndUpdate(context.getClickedPos(), MAGIC_MAP.get(clickedBlock).defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), context.getHand());
        }

        return InteractionResult.SUCCESS;
    }
}
