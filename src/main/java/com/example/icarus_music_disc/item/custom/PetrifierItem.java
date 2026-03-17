package com.example.icarus_music_disc.item.custom;

import com.example.icarus_music_disc.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PetrifierItem extends Item {
    public PetrifierItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pItem, Player pPlayer, LivingEntity pEntity, InteractionHand pInteractionHand) {

        if (!pPlayer.level().isClientSide()) {
            // effet "fige" l'entité
            pEntity.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0);
            pEntity.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(0.0);
            pEntity.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(0.0);
            pEntity.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.0);
            pItem.shrink(1);
            pEntity.level().playSound(pPlayer,pEntity.blockPosition(),SoundEvents.STONE_PLACE,pEntity.getSoundSource(),1f,1f);
        }

        return InteractionResult.SUCCESS;
    }
}