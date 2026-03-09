package net.nicolad.berinjelapunx.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BerinjelasBootsItem extends ArmorItem {


    public BerinjelasBootsItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {super(pMaterial, pType, pProperties);}

    @Override
    public boolean isEnchantable(@NotNull ItemStack pStack) {
        return false;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide) {
            if (!player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)||!player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 0, false, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 0, false, false, false));
            }
        }
    }
}

