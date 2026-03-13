package net.nicolad.berinjelapunx.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nicolad.berinjelapunx.BerinjelaPunx;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BerinjelaPunx.MOD_ID);

    public static final RegistryObject<MobEffect> NICOTINE_EFFECT = MOB_EFFECTS.register("nicotine",
            () -> new NicotineEffect(MobEffectCategory.NEUTRAL, 0x787878));


    public static void  register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
