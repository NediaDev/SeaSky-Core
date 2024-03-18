package fr.seaskycore.pirate.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PiocheListener {

    public static ItemStack createPiratePioche() {
        ItemStack GLAIVE = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = GLAIVE.getItemMeta();

        meta.setCustomModelData(Integer.valueOf("10002"));
        meta.setDisplayName("§5§l✤ Pioche du Pirate ✤");
        meta.addEnchant(Enchantment.DIG_SPEED, 6, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);


        meta.setLore(Arrays.asList(
        ));





        GLAIVE.setItemMeta(meta);

        return GLAIVE;
    }
}
