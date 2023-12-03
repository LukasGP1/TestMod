package de.lulkas_.testmod.block;

import de.lulkas_.testmod.TestMod;
import de.lulkas_.testmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block", BLOCKS.register("test_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK))),
            new Item.Properties()
    );

    public static final RegistryObject<Block> RAW_TEST_BLOCK = registerBlock("raw_test_block", BLOCKS.register("raw_test_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK))),
            new Item.Properties()
    );

    public static final RegistryObject<Block> TEST_ORE = registerBlock("test_ore", BLOCKS.register("test_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE))),
            new Item.Properties()
    );

    public static final RegistryObject<Block> DEEPSLATE_TEST_ORE = registerBlock("deepslate_test_ore", BLOCKS.register("deepslate_test_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE))),
            new Item.Properties()
    );

    public static final RegistryObject<Block> NETHER_TEST_ORE = registerBlock("nether_test_ore", BLOCKS.register("nether_test_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE))),
            new Item.Properties()
    );

    public static final RegistryObject<Block> END_TEST_ORE = registerBlock("end_test_ore", BLOCKS.register("end_test_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE))),
            new Item.Properties()
    );

    private static <T extends Block>RegistryObject<T> registerBlock(String ItemName, RegistryObject<T> block, Item.Properties itemProperties) {
        RegistryObject<T> toReturn = block;
        registerBlockItem(ItemName, itemProperties, block);
        return toReturn;
    }

    private static <T extends  Block>RegistryObject<Item> registerBlockItem(String name, Item.Properties itemProperties, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
