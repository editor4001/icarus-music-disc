package com.example.icarus_music_disc.item.custom;

import com.example.icarus_music_disc.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide()) {
            BlockPos positionClicked = context.getClickedPos();
            Player player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0 ; i <= positionClicked.getY() + 64 ; i++) {
                BlockState state = context.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }
            if(!foundBlock){
                player.sendSystemMessage(Component.literal("No valuables blocks found"));
            }


            if(player != null) {
                context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
                        playerr -> player.broadcastBreakEvent(player.getUsedItemHand()));
            }

        }
        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + block.getName().getString() + " at: " + blockPos.toShortString()));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.DIAMOND_ORE);
    }
}
