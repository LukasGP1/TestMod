package de.lulkas_.testmod.datagen;

import de.lulkas_.testmod.TestMod;
import de.lulkas_.testmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RAW_TEST_BLOCK);
        blockWithItem(ModBlocks.TEST_BLOCK);

        blockWithItem(ModBlocks.DEEPSLATE_TEST_ORE);
        blockWithItem(ModBlocks.END_TEST_ORE);
        blockWithItem(ModBlocks.NETHER_TEST_ORE);
        blockWithItem(ModBlocks.TEST_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
