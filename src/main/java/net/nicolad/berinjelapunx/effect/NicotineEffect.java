package net.nicolad.berinjelapunx.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;

public class NicotineEffect extends MobEffect {

    public NicotineEffect(MobEffectCategory category, int color) {
        super(category, color);

        // Velocidade de movimento
        this.addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                "b6c1d9e0-1c4a-4c8c-b6c1-111111111111",
                0.02,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );

        // Velocidade de ataque (simula reflexo / foco)
        this.addAttributeModifier(
                Attributes.ATTACK_SPEED,
                "b6c1d9e0-1c4a-4c8c-b6c1-222222222222",
                0.10,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );

        // Fraqueza (queda de pressão quando nível alto)
        this.addAttributeModifier(
                Attributes.ATTACK_DAMAGE,
                "b6c1d9e0-1c4a-4c8c-b6c1-333333333333",
                -0.15,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );
    }

    @Override
    public double getAttributeModifierValue(int amplifier, AttributeModifier modifier) {
        // aumenta intensidade conforme nível da nicotina
        return modifier.getAmount() * (amplifier + 1);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        if(!pLivingEntity.level().isClientSide && pLivingEntity instanceof Player player){

            int duration = player.getEffect(this).getDuration();

            if (pAmplifier == 0) {
                if(duration % 100 == 0) {
                    player.getFoodData().eat(1, 0.0f);
                }
            }

            if (pAmplifier == 2) {
                player.getFoodData().addExhaustion(0.4f);
            }

            if (pAmplifier >= 3) {
                player.getFoodData().addExhaustion(1.5f);
                if(duration >= 3600 && !player.hasEffect(MobEffects.BLINDNESS)){
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0, false, false, false));
                }
            }

            if (pAmplifier == 4){
                player.hurt(player.damageSources().magic(), 2.0f);
            }
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return pDuration % 20 == 0;
    }
}