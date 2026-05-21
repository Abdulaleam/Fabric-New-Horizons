package net.rainy.newhorizons.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import net.minecraft.world.item.component.Consumables;
import java.util.List;

import static net.minecraft.world.item.component.Consumables.defaultFood;

public class ModFoods  {
    public static final Consumable BASKOTA_COOKED = Consumables.defaultFood()
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(
                            List.of(
                                    new MobEffectInstance(MobEffects.REGENERATION, 200, 1),
                                    new MobEffectInstance(MobEffects.RESISTANCE, 9000, 2),
                                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10000, 0),
                                    new MobEffectInstance(MobEffects.ABSORPTION, 8400, 3),
                             new MobEffectInstance(MobEffects.LEVITATION, 400, 3),
                                    new MobEffectInstance(MobEffects.SATURATION, 400, 3)

                                    )
                    )
            )
            .build();
    public static final FoodProperties BASKOTA_RAW = new FoodProperties.Builder().nutrition(1).saturationModifier(1).build();
    public static final Consumable BASKOTA_BURNT = Consumables.defaultFood()
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(
                            List.of(
                                    new MobEffectInstance(MobEffects.POISON, 100, 1),
                                    new MobEffectInstance(MobEffects.WITHER, 100, 2),
                                    new MobEffectInstance(MobEffects.HUNGER, 100, 0),
                                    new MobEffectInstance(MobEffects.BLINDNESS, 100, 3),
                                    new MobEffectInstance(MobEffects.SLOWNESS, 100, 3)

                            )
                    )
            )
            .build();



}
