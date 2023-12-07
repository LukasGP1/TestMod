package de.lulkas_.testmod.item.custom;

import de.lulkas_.testmod.util.ArrayListBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockDetectorItem extends Item {
    private ArrayListBuilder<Block> blocks;

    public BlockDetectorItem(Properties pProperties, ArrayListBuilder<Block> blocks) {
        super(pProperties);
        this.blocks = blocks;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide) {
            BlockPos posClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= posClicked.getY() + 64 && !foundBlock; i++) {
                BlockState state = pContext.getLevel().getBlockState(posClicked.below(i));

                if(blocks.contains(state.getBlock())) {
                    foundBlock = true;

                    player.sendSystemMessage(Component.literal("found " + state + " at " + posClicked.below(i).getY()));
                }

            }

        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("item.test_mod.block_detector_item.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
