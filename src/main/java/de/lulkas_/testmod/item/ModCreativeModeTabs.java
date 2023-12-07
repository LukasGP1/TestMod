package de.lulkas_.testmod.item;

import de.lulkas_.testmod.TestMod;
import de.lulkas_.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.TEST_INGOT.get()))
                    .title(Component.translatable("creative_tab.test_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TEST_INGOT.get());
                        pOutput.accept(ModItems.RAW_TEST_INGOT.get());
                        pOutput.accept(ModItems.TEST_NUGGET.get());
                        pOutput.accept(ModItems.DIAMOND_DETECTOR.get());
                        pOutput.accept(ModItems.IRON_DETECTOR.get());
                        pOutput.accept(ModItems.GOLD_DETECTOR.get());
                        pOutput.accept(ModItems.SCULK_DETECTOR.get());

                        pOutput.accept(ModBlocks.TEST_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_TEST_BLOCK.get());
                        pOutput.accept(ModBlocks.TEST_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_TEST_ORE.get());
                        pOutput.accept(ModBlocks.END_TEST_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_TEST_ORE.get());
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
