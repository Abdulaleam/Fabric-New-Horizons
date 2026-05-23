package net.rainy.newhorizons.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.rainy.newhorizons.Item_package.mah_item;
// so im trying make a block called reducer that turns my oxidized items into  a normal one ;P

public class Reducer extends Block {
    public Reducer(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.addParticle(ParticleTypes.GLOW, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 1, 0);
        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS, 2f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        // ezzzzz OOooo Shiny stuff.
        if(entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200));
        }

        // it should reduce my oxidized dust into Iron ima go make the crusher.
        if(entity instanceof ItemEntity itemEntity) {
            // lol i like how most of the method the Guide and my friend are teaching me is basically making methods and if  statments of smth non existent
            // Perfect Schizophrenic over here.
            if(isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(mah_item.REDUCED_IRON, itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(level, pos, onState, entity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(mah_item.OXIDIZEDIRON_DUST);
    }}