package net.nicolad.berinjelapunx.item.custom;


import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nicolad.berinjelapunx.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class MarlboroItem extends Item {

    public MarlboroItem(Properties pProperties) {super(pProperties);}

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        pTooltipComponents.add(Component.translatable("tooltip.berinjela_punx.marlboro"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {

            ItemStack cigarette = new ItemStack(ModItems.CIGARETTE.get());

            if (!player.getInventory().add(cigarette)) {

                player.drop(cigarette, false);
            }

            stack.hurtAndBreak(1, player, (p) -> {});
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
