package fr.seaskycore.furnace.cook;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import java.util.*;

public class Cook
{
    private static final Map<Material, Material> COOKED_ITEMS;

    public void cookItemInHand(final Player player) {
        final ItemStack itemInHand = player.getInventory().getItemInMainHand();
        final Material itemMaterial = itemInHand.getType();
        final Material cookedItemMaterial = Cook.COOKED_ITEMS.get(itemMaterial);
        if (cookedItemMaterial != null) {
            final ItemStack cookedItemStack = new ItemStack(cookedItemMaterial, itemInHand.getAmount());
            player.getInventory().setItemInMainHand(cookedItemStack);
        }
    }

    public void cookAllItemsInInventory(final Player player) {
        final Inventory inventory = (Inventory)player.getInventory();
        for (int i = 0; i < inventory.getSize(); ++i) {
            final ItemStack itemStack = inventory.getItem(i);
            if (itemStack != null) {
                final Material itemMaterial = itemStack.getType();
                final Material cookedItemMaterial = Cook.COOKED_ITEMS.get(itemMaterial);
                if (cookedItemMaterial != null) {
                    final int amount = itemStack.getAmount();
                    final ItemStack cookedItemStack = new ItemStack(cookedItemMaterial, amount);
                    inventory.setItem(i, cookedItemStack);
                }
            }
        }
    }

    static {
        (COOKED_ITEMS = new HashMap<Material, Material>()).put(Material.RAW_IRON, Material.IRON_INGOT);
        Cook.COOKED_ITEMS.put(Material.RAW_IRON_BLOCK, Material.IRON_BLOCK);
        Cook.COOKED_ITEMS.put(Material.IRON_ORE, Material.IRON_INGOT);
        Cook.COOKED_ITEMS.put(Material.DEEPSLATE_IRON_ORE, Material.IRON_INGOT);
        Cook.COOKED_ITEMS.put(Material.RAW_GOLD, Material.GOLD_INGOT);
        Cook.COOKED_ITEMS.put(Material.RAW_GOLD_BLOCK, Material.GOLD_BLOCK);
        Cook.COOKED_ITEMS.put(Material.GOLD_ORE, Material.GOLD_INGOT);
        Cook.COOKED_ITEMS.put(Material.DEEPSLATE_GOLD_ORE, Material.GOLD_INGOT);
        Cook.COOKED_ITEMS.put(Material.RAW_COPPER, Material.COPPER_INGOT);
        Cook.COOKED_ITEMS.put(Material.RAW_COPPER_BLOCK, Material.COPPER_BLOCK);
        Cook.COOKED_ITEMS.put(Material.COPPER_ORE, Material.COPPER_INGOT);
        Cook.COOKED_ITEMS.put(Material.DEEPSLATE_COPPER_ORE, Material.COPPER_INGOT);
        Cook.COOKED_ITEMS.put(Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP);
        Cook.COOKED_ITEMS.put(Material.BEEF, Material.COOKED_BEEF);
        Cook.COOKED_ITEMS.put(Material.PORKCHOP, Material.COOKED_PORKCHOP);
        Cook.COOKED_ITEMS.put(Material.CHICKEN, Material.COOKED_CHICKEN);
        Cook.COOKED_ITEMS.put(Material.MUTTON, Material.COOKED_MUTTON);
        Cook.COOKED_ITEMS.put(Material.RABBIT, Material.COOKED_RABBIT);
        Cook.COOKED_ITEMS.put(Material.COD, Material.COOKED_COD);
        Cook.COOKED_ITEMS.put(Material.SALMON, Material.COOKED_SALMON);
        Cook.COOKED_ITEMS.put(Material.POTATO, Material.BAKED_POTATO);
        Cook.COOKED_ITEMS.put(Material.BEETROOT, Material.BEETROOT_SOUP);
        Cook.COOKED_ITEMS.put(Material.CACTUS, Material.GREEN_DYE);
        Cook.COOKED_ITEMS.put(Material.KELP, Material.DRIED_KELP);
        Cook.COOKED_ITEMS.put(Material.CHORUS_FRUIT, Material.POPPED_CHORUS_FRUIT);
        Cook.COOKED_ITEMS.put(Material.SWEET_BERRIES, Material.SWEET_BERRIES);
        Cook.COOKED_ITEMS.put(Material.SWEET_BERRY_BUSH, Material.SWEET_BERRIES);
        Cook.COOKED_ITEMS.put(Material.POTATOES, Material.BAKED_POTATO);
        Cook.COOKED_ITEMS.put(Material.RABBIT_STEW, Material.RABBIT_STEW);
        Cook.COOKED_ITEMS.put(Material.COBBLESTONE, Material.STONE);
    }
}

