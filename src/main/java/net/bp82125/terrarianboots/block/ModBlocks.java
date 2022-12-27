package net.bp82125.terrarianboots.block;

import net.bp82125.terrarianboots.TerrarianBoots;
import net.bp82125.terrarianboots.block.custom.AsphaltBlock;
import net.bp82125.terrarianboots.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block OBSIDIAN_SKULL_BLOCK = registerBlock("obsidian_skull_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(50f).requiresTool()), ModItemGroup.TERRARIAN_BOOTS);
    public static final Block ASPHALT_BLOCK = registerBlock("asphalt_block",
            new AsphaltBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.TERRARIAN_BOOTS);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(TerrarianBoots.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(TerrarianBoots.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        TerrarianBoots.LOGGER.debug("Resgistering ModBlocks for" + TerrarianBoots.MOD_ID);
    }
}
