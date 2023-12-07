package de.lulkas_.testmod.item;

import de.lulkas_.testmod.TestMod;
import de.lulkas_.testmod.item.custom.BlockDetectorItem;
import de.lulkas_.testmod.util.ArrayListBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

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

    public static RegistryObject<Item> DIAMOND_DETECTOR = ITEMS.register("diamond_detector",
            () -> new BlockDetectorItem(new Item.Properties(), new ArrayListBuilder<Block>()
                    .add(Blocks.DIAMOND_ORE)
                    .add(Blocks.DEEPSLATE_DIAMOND_ORE)
            )
    );

    public static final RegistryObject<Item> IRON_DETECTOR = ITEMS.register("iron_detector",
            () -> new BlockDetectorItem(new Item.Properties(), new ArrayListBuilder<Block>()
                    .add(Blocks.IRON_ORE)
                    .add(Blocks.DEEPSLATE_IRON_ORE)
            )
    );

    public static final RegistryObject<Item> GOLD_DETECTOR = ITEMS.register("gold_detector",
            () -> new BlockDetectorItem(new Item.Properties(), new ArrayListBuilder<Block>()
                    .add(Blocks.GOLD_ORE)
                    .add(Blocks.DEEPSLATE_GOLD_ORE)
            )
    );
    public static final RegistryObject<Item> SCULK_DETECTOR = ITEMS.register("sculk_detector",
            () -> new BlockDetectorItem(new Item.Properties(), new ArrayListBuilder<Block>()
                    .add(Blocks.SCULK)
                    .add(Blocks.SCULK_SENSOR)
                    .add(Blocks.SCULK_CATALYST)
                    .add(Blocks.SCULK_SHRIEKER)
                    .add(Blocks.SCULK_VEIN)
            )
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
