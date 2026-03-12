package net.nicolad.berinjelapunx.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import net.nicolad.berinjelapunx.item.ModItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;


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
                player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1200, 0,false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0,false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1200, 0,false, false, true));
                pLevel.addParticle(
                        ParticleTypes.SMOKE,
                        player.getX(),
                        player.getY() + 1.5,
                        player.getZ(),
                        0.1, 0.1, 0.1
                );

                if (!player.getAbilities().instabuild) {
                    pStack.hurtAndBreak(1, player, p -> {});
                }
            }
        }

        return pStack;
    }
}
