package de.lulkas_.testmod.item;

import de.lulkas_.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> TEST_INGOT = ITEMS.register("test_ingot",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> RAW_TEST_INGOT = ITEMS.register("raw_test_ingot",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> TEST_NUGGET = ITEMS.register("test_nugget",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
