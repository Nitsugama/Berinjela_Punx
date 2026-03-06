package net.nicolad.berinjelapunx.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nicolad.berinjelapunx.BerinjelaPunx;
import org.apache.commons.lang3.math.IEEE754rUtils;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BerinjelaPunx.MOD_ID);

    // para fazer um novo item, devemos apenas criar um novo RegistryObject

    //SAPPHIRE
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));

    //RAW SAPPHIRE
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRACK = ITEMS.register("crack",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHEMICAL_MIX = ITEMS.register("chemical_mix",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}



