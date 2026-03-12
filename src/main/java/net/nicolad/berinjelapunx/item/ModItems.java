package net.nicolad.berinjelapunx.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nicolad.berinjelapunx.BerinjelaPunx;
import net.nicolad.berinjelapunx.item.custom.BerinjelasBootsItem;
import net.nicolad.berinjelapunx.item.custom.CigaretteItem;
import net.nicolad.berinjelapunx.item.custom.CrackPipeItem;
import net.nicolad.berinjelapunx.sound.ModSounds;

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

    //CIGARRO
    public static final RegistryObject<Item> CIGARETTE = ITEMS.register("cigarette",
            () -> new CigaretteItem(new Item.Properties().stacksTo(1).durability(2)));

    //ZIPPO
    public static final RegistryObject<Item> ZIPPO = ITEMS.register("zippo",
            () -> new Item(new Item.Properties().stacksTo(1).durability(100)));

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

    //CRUCIFIXO
    public static final RegistryObject<Item> CRUX = ITEMS.register("crux",
            () -> new PickaxeItem(Tiers.IRON, 7, 1,  new Item.Properties()));



    //-------------------------------------ARMADURA-----------------------------------//

    public static final RegistryObject<Item> BERINJELAS_BOOTS = ITEMS.register("berinjelas_boots",
            () -> new BerinjelasBootsItem(ModArmorMaterials.BERINJELAS, ArmorItem.Type.BOOTS,  new Item.Properties().setNoRepair()));


    //-------------------------------------MUSIC DISC-----------------------------------//

    public static final  RegistryObject<Item> PAWN_SHOP_MUSIC_DISC = ITEMS.register("pawn_shop_music_disc",
            () -> new RecordItem(6, ModSounds.PAWN_SHOP, new Item.Properties().stacksTo(1), 7340));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}





