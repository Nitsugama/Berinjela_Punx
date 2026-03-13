package net.nicolad.berinjelapunx.item.custom;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.nicolad.berinjelapunx.effect.ModEffects;
import net.nicolad.berinjelapunx.item.ModItems;


public class CigaretteItem extends Item {
    public CigaretteItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack offhandItem = pPlayer.getOffhandItem();
        if (!offhandItem.is(ModItems.ZIPPO.get())) {
            return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
        }

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
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
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        if (!pLevel.isClientSide) {

            if (pLivingEntity instanceof Player player) {

                MobEffectInstance currentEffect = player.getEffect(ModEffects.NICOTINE_EFFECT.get());

                int newAmplifier = 0;

                if(currentEffect != null){
                    newAmplifier = currentEffect.getAmplifier() +1;
                }

                if( newAmplifier > 4){
                    newAmplifier = 4;
                }

                player.addEffect(new MobEffectInstance(ModEffects.NICOTINE_EFFECT.get(), 3600, newAmplifier, false, false, true));

                ItemStack offhand = player.getOffhandItem();
                if(offhand.is(ModItems.ZIPPO.get())){
                    offhand.hurtAndBreak(1, player, (p) -> {});
                }

                if (pStack.getDamageValue() >= pStack.getMaxDamage() -1){
                    return new ItemStack(ModItems.CIGARETTE_BUTT.get());
                }
                pStack.hurtAndBreak(1,player, (p) ->{});

                if(pLevel instanceof ServerLevel serverLevel){
                    serverLevel.sendParticles(
                            ParticleTypes.SMOKE,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            8,
                            0.2, 0.2, 0.2,
                            0.01
                            );
                }
            }
        }

        return pStack;
    }
}
