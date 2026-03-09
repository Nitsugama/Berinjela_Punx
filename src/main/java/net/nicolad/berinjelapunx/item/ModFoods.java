package net.nicolad.berinjelapunx.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_SACK = new FoodProperties.Builder()
            .alwaysEat()
            .meat()
            .nutrition(-2)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 2), 0.5f)
            .build();

    public static final FoodProperties COOKED_SACK = new FoodProperties.Builder()
            .alwaysEat()
            .meat()
            .nutrition(3)
            .effect(()-> new MobEffectInstance(MobEffects.ABSORPTION, 500, 1), 0.3f)
            .build();
}
