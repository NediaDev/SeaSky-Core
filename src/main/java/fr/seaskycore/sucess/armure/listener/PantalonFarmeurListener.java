package fr.seaskycore.sucess.armure.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class PantalonFarmeurListener {


    public static ItemStack createPantalon() {
        ItemStack casquePantalon = new ItemStack(Material.LEATHER_LEGGINGS);

        LeatherArmorMeta meta = (LeatherArmorMeta) casquePantalon.getItemMeta();


        meta.setColor(org.bukkit.Color.fromRGB(115, 0, 255)); // 115, 0, 255

        meta.setCustomModelData(Integer.valueOf("10005"));
        meta.setDisplayName("§f✤ §2§lPantalon du Farmeur §f✤");
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 8, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        meta.setLore(Arrays.asList(
                "§aEffets sur le Pantalon:",
                "§f• §fProtection contre le feux 1",
                " ",
                "§aDébloque les effets suiviants :",
                "§f• Effet d'invibilité"
        ));

        casquePantalon.setItemMeta(meta);

        return casquePantalon;
    }

    public static boolean isPantalonFarmeur(ItemStack item) {
        if (item != null && item.getType() == Material.LEATHER_LEGGINGS && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();

            if (meta.getDisplayName() != null && meta.getDisplayName().equals("§f✤ §2§lPantalon du Farmeur §f✤")) {
                return true;
            }
        }
        return false;
    }
}
