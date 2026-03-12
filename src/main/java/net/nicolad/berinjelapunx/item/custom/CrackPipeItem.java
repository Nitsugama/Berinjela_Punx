package net.nicolad.berinjelapunx.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.nicolad.berinjelapunx.item.ModItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;


public class CrackPipeItem extends Item {
    public CrackPipeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    @NotNull
    @ParametersAreNonnullByDefault
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        pPlayer.startUsingItem(pUsedHand);


        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    @Override
    @NotNull
    @ParametersAreNonnullByDefault
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    @NotNull
    @ParametersAreNonnullByDefault
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        pTooltipComponents.add(Component.translatable("tooltip.berinjela_punx.crack_pipe"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    @NotNull
    @ParametersAreNonnullByDefault
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide) {
            if (pLivingEntity instanceof Player player) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 3, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 3,false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 300, 3,false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 3,false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 300, 1,false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 3,false, false, true));

                if (!player.getAbilities().instabuild) {
                    pStack.shrink(1);
                }

                ItemStack pipe = new ItemStack(ModItems.PIPE.get());

                if (!player.getInventory().add(pipe)) {
                    player.drop(pipe, false);
                }
            }
        }

        return pStack;
    }
}
