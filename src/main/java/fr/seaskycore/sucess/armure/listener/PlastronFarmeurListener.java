package fr.seaskycore.sucess.armure.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class PlastronFarmeurListener {

    public static ItemStack createPlastron() {
        ItemStack PlastronFarmeur = new ItemStack(Material.LEATHER_CHESTPLATE);

        LeatherArmorMeta meta = (LeatherArmorMeta) PlastronFarmeur.getItemMeta();


        meta.setColor(org.bukkit.Color.fromRGB(115, 0, 255)); // 115, 0, 255

        meta.setCustomModelData(Integer.valueOf("10005"));
        meta.setDisplayName("§f✤ §2§lPlastron du Farmeur §f✤");
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 8, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        meta.setLore(Arrays.asList(
                "§aEffets sur le Plastron:",
                "§f• §fAucune perte de nourriture 1",
                " ",
                "§aDébloque les effets suiviants :",
                "§f• Effet d'invibilité"
        ));

        PlastronFarmeur.setItemMeta(meta);

        return PlastronFarmeur;
    }

    public static boolean isPlastronFarmeur(ItemStack item) {
        if (item != null && item.getType() == Material.LEATHER_CHESTPLATE && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();

            if (meta.getDisplayName() != null && meta.getDisplayName().equals("§f✤ §2§lPlastron du Farmeur §f✤")) {
                return true;
            }
        }
        return false;
    }
}


