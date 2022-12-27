package net.bp82125.terrarianboots.item;

import net.bp82125.terrarianboots.TerrarianBoots;
import net.bp82125.terrarianboots.item.custom.DiceItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OBSIDIAN_SKULL = registerItem(
            "obsidian_skull",
            new Item(new Item.Settings()), ModItemGroup.TERRARIAN_BOOTS
    );
    public static final Item OBSIDIAN_SHARD = registerItem(
            "obsidian_shard",
            new Item(new Item.Settings()), ModItemGroup.TERRARIAN_BOOTS
    );
    public static final Item LAVA_WADERS = registerItem(
            "lava_waders",
            new Item(new Item.Settings()), ModItemGroup.TERRARIAN_BOOTS
);
    public static final Item WATER_WALKERS = registerItem(
            "water_walkers",
            new Item(new Item.Settings()), ModItemGroup.TERRARIAN_BOOTS
);
    public static final Item DICE = registerItem(
            "dice",
            new DiceItem(new Item.Settings()), ModItemGroup.TERRARIAN_BOOTS
);

    private static Item registerItem(String name, Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(TerrarianBoots.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TerrarianBoots.LOGGER.debug("Registering Mod Items for " + TerrarianBoots.MOD_ID);
    }
}
