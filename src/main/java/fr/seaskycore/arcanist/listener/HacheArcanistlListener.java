package fr.seaskycore.arcanist.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class HacheArcanistlListener {

    public static ItemStack createArcanistHache() {
        ItemStack GLAIVE = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = GLAIVE.getItemMeta();

        meta.setCustomModelData(Integer.valueOf("10002"));
        meta.setDisplayName("Hâche du Arcanist");
        meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 8, true);
        meta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        meta.setUnbreakable(true);


        meta.setLore(Arrays.asList(
        ));





        GLAIVE.setItemMeta(meta);

        return GLAIVE;
    }
}
