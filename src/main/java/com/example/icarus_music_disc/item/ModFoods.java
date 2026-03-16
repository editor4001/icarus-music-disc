package com.example.icarus_music_disc.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .nutrition(20)
            .alwaysEat()
            .fast()
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 800, 1),1)
            .build();
}
