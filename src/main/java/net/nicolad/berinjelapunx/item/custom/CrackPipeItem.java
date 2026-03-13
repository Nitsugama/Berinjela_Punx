package net.nicolad.berinjelapunx.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.phys.Vec3;
import net.nicolad.berinjelapunx.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class CrackPipeItem extends Item {
    public CrackPipeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack offhandItem = pPlayer.getOffhandItem();
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if (!offhandItem.is(ModItems.ZIPPO.get())) {
            return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
        }

        pPlayer.startUsingItem(pUsedHand);

        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        pTooltipComponents.add(Component.translatable("tooltip.berinjela_punx.crack_pipe"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
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

                ItemStack offhand = player.getOffhandItem();
                if(offhand.is(ModItems.ZIPPO.get())){
                    offhand.hurtAndBreak(1, player, (p) -> {});
                }

                if (!player.getInventory().add(pipe)) {
                    player.drop(pipe, false);
                }
            }
        }

        return pStack;
    }
}
