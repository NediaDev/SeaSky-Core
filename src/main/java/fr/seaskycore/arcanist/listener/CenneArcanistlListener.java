package fr.seaskycore.arcanist.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CenneArcanistlListener {

    public static ItemStack createArcanistCanne() {
        ItemStack GLAIVE = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = GLAIVE.getItemMeta();

        meta.setCustomModelData(Integer.valueOf("6"));
        meta.setDisplayName("Canne du Arcanist");
        meta.addEnchant(Enchantment.LUCK, 10, true);
        meta.addEnchant(Enchantment.LURE, 10, true);
        meta.setUnbreakable(true);


        meta.setLore(Arrays.asList(
        ));





        GLAIVE.setItemMeta(meta);

        return GLAIVE;
    }
}
