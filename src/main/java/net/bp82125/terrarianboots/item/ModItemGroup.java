package net.bp82125.terrarianboots.item;

import net.bp82125.terrarianboots.TerrarianBoots;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class ModItemGroup {
    public static final ItemGroup TERRARIAN_BOOTS = FabricItemGroup.builder(new Identifier(TerrarianBoots.MOD_ID, "terrarian_boots"))
            .icon(() -> new ItemStack(ModItems.LAVA_WADERS))
            .build();
}