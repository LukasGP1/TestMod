package de.lulkas_.testmod.datagen;

import de.lulkas_.testmod.TestMod;
import de.lulkas_.testmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TEST_BLOCK.get(),
                        ModBlocks.RAW_TEST_BLOCK.get(),
                        ModBlocks.TEST_ORE.get(),
                        ModBlocks.DEEPSLATE_TEST_ORE.get(),
                        ModBlocks.NETHER_TEST_ORE.get(),
                        ModBlocks.END_TEST_ORE.get()
                )
        ;

        //this.tag(BlockTags.NEEDS_STONE_TOOL).add();

        //this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add();

        //this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add();

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TEST_BLOCK.get(),
                        ModBlocks.RAW_TEST_BLOCK.get(),
                        ModBlocks.TEST_ORE.get(),
                        ModBlocks.DEEPSLATE_TEST_ORE.get(),
                        ModBlocks.NETHER_TEST_ORE.get(),
                        ModBlocks.END_TEST_ORE.get()
                )
        ;
    }
}
