package fr.seaskycore.sucess.armure.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class CasqueFarmeurListener {

    public static ItemStack createFarmeurCasque() {


        ItemStack casqueFarmeur = new ItemStack(Material.LEATHER_HELMET);

        LeatherArmorMeta meta = (LeatherArmorMeta) casqueFarmeur.getItemMeta();


        meta.setColor(org.bukkit.Color.fromRGB(115, 0, 255)); // 115, 0, 255


        meta.setCustomModelData(Integer.valueOf("10005"));
        meta.setDisplayName("§f✤ §2§lCasque du Farmeur §f✤");
        meta.addEnchant(Enchantment.DIG_SPEED, 8, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        meta.setLore(Arrays.asList(
                "§aEffets sur le casque:",
                "§f• §fCélérité 1",
                " ",
                "§aDébloque les effets suiviants :",
                "§f• Effet d'invibilité"
        ));

        casqueFarmeur.setItemMeta(meta);

        return casqueFarmeur;
    }

    public static boolean isCasqueFarmeur(ItemStack item) {
        if (item != null && item.getType() == Material.LEATHER_HELMET && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();

            if (meta.getDisplayName() != null && meta.getDisplayName().equals("§f✤ §2§lCasque du Farmeur §f✤")) {
                return true;
            }
        }
        return false;
    }
}
