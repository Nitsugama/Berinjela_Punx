package net.nicolad.berinjelapunx.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nicolad.berinjelapunx.BerinjelaPunx;
import net.nicolad.berinjelapunx.item.custom.CrackPipeItem;
import org.apache.commons.lang3.math.IEEE754rUtils;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BerinjelaPunx.MOD_ID);

    // para fazer um novo item, devemos apenas criar um novo RegistryObject



    //--------------------------------ITEMS DO MOD--------------------------------//

    //CACHIMBO
    public static final RegistryObject<Item> PIPE = ITEMS.register("pipe",
            () -> new Item(new Item.Properties().stacksTo(1)));

    // CACHIMBO COM CRACK
    public static final RegistryObject<Item> CRACK_PIPE = ITEMS.register("crack_pipe",
            () -> new CrackPipeItem(new Item.Properties().stacksTo(1)));

    //CRACK
    public static final RegistryObject<Item> CRACK = ITEMS.register("crack",
            () -> new Item(new Item.Properties()));

    // MISTURA QUIMICA
    public static final RegistryObject<Item> CHEMICAL_MIX = ITEMS.register("chemical_mix",
            () -> new Item(new Item.Properties()));

    //-----------------------------------COMIDAS-----------------------------------//

    //SACO CRU
    public static final RegistryObject<Item> RAW_SACK = ITEMS.register("raw_sack",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_SACK)));

    //SACO ASSADO
    public static final RegistryObject<Item> COOKED_SACK = ITEMS.register("cooked_sack",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_SACK)));


    //----------------------------------FERRAMENTAS---------------------------------//

    //CRUCIFIXO (ainda nao é uma ferramenta)
    public static final RegistryObject<Item> CRUX = ITEMS.register("crux",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}



