package de.lulkas_.testmod.datagen.loot;

import de.lulkas_.testmod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import de.lulkas_.testmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TEST_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_TEST_BLOCK.get());

        this.add(ModBlocks.TEST_ORE.get(), block -> createCopperLikeOreDrops(ModBlocks.TEST_ORE.get(), ModItems.RAW_TEST_INGOT.get()));
        this.add(ModBlocks.DEEPSLATE_TEST_ORE.get(), block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_TEST_ORE.get(), ModItems.RAW_TEST_INGOT.get()));
        this.add(ModBlocks.NETHER_TEST_ORE.get(), block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_TEST_ORE.get(), ModItems.RAW_TEST_INGOT.get()));
        this.add(ModBlocks.END_TEST_ORE.get(), block -> createCopperLikeOreDrops(ModBlocks.TEST_ORE.get(), ModItems.RAW_TEST_INGOT.get()));

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
