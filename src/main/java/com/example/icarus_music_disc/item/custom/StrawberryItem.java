package com.example.icarus_music_disc.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StrawberryItem extends Item {

    public static boolean consumed = false;

    public StrawberryItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        return super.use(world, player, hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        // par exemple si tu veux un effet seulement sur le joueur
        if (entity instanceof Player player && !consumed) {
            player.sendSystemMessage(Component.literal("Miam !"));
            consumed = true;
            try{
                Thread.sleep(2000);
                consumed = false;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return super.finishUsingItem(stack, world, entity);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> pComponent, TooltipFlag p_41424_) {

        pComponent.add(Component.translatable("tooltip.icarus_music_disc.strawberry"));

        super.appendHoverText(p_41421_, p_41422_, pComponent, p_41424_);
    }
}
