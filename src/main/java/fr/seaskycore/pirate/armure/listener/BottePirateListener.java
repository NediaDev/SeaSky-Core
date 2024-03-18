package fr.seaskycore.pirate.armure.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class BottePirateListener {

    public static ItemStack createBottePirate() {


        ItemStack casqueFarmeur = new ItemStack(Material.LEATHER_BOOTS);

        LeatherArmorMeta meta = (LeatherArmorMeta) casqueFarmeur.getItemMeta();


        meta.setColor(org.bukkit.Color.fromRGB(214, 0, 66)); // 253, 193, 29


        meta.setCustomModelData(Integer.valueOf("10009"));
        meta.setDisplayName("§5§l✤ Botte du Pirate ✤");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.setUnbreakable(true);


        meta.setLore(Arrays.asList(
                "§aEffets sur le casque:",
                "§f• §fSpeed 2 "
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
