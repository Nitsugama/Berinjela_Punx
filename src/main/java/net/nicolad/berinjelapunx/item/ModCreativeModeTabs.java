package net.nicolad.berinjelapunx.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nicolad.berinjelapunx.BerinjelaPunx;
import net.nicolad.berinjelapunx.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BerinjelaPunx.MOD_ID);


        // TAB DO CRIATIVO
    public static final RegistryObject<CreativeModeTab> SAULOLITEMS = CREATIVE_MODE_TABS.register("saulolitems",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRUX.get()))
                    .title(Component.translatable("creativetab.saulolitems"))
                    .displayItems((pParameters, pOutput) ->{
                        pOutput.accept(ModItems.CHEMICAL_MIX.get());
                        pOutput.accept(ModItems.CRACK.get());
                        pOutput.accept(ModItems.PIPE.get());
                        pOutput.accept(ModItems.CRACK_PIPE.get());
                        pOutput.accept(ModItems.PAWN_SHOP_MUSIC_DISC.get());


                        pOutput.accept(ModItems.RAW_SACK.get());
                        pOutput.accept(ModItems.COOKED_SACK.get());


                        pOutput.accept(ModItems.CRUX.get());


                        pOutput.accept(ModItems.BERINJELAS_BOOTS.get());


                        pOutput.accept(ModBlocks.CRACK_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
