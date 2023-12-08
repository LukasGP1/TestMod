package de.lulkas_.testmod.datagen;

import de.lulkas_.testmod.TestMod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import de.lulkas_.testmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DIAMOND_DETECTOR);
        simpleItem(ModItems.GOLD_DETECTOR);
        simpleItem(ModItems.IRON_DETECTOR);
        simpleItem(ModItems.RAW_TEST_INGOT);
        simpleItem(ModItems.SCULK_DETECTOR);
        simpleItem(ModItems.TEST_INGOT);
        simpleItem(ModItems.TEST_NUGGET);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TestMod.MOD_ID, "item/" + item.getId().getPath())
        );
    }
}
