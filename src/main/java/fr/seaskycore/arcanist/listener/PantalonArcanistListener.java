package fr.seaskycore.arcanist.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class PantalonArcanistListener {

    public static ItemStack createPantalonCrcanist() {


        ItemStack casqueFarmeur = new ItemStack(Material.LEATHER_CHESTPLATE);

        LeatherArmorMeta meta = (LeatherArmorMeta) casqueFarmeur.getItemMeta();


        meta.setColor(org.bukkit.Color.fromRGB( 0, 153, 219)); // 0, 153, 219


        meta.setCustomModelData(Integer.valueOf("10013"));
        meta.setDisplayName("Plastron du Arcanist");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        meta.setUnbreakable(true);


        meta.setLore(Arrays.asList(
        ));

        casqueFarmeur.setItemMeta(meta);

        return casqueFarmeur;
    }

    public static boolean isCasqueFarmeur(ItemStack item) {
        if (item != null && item.getType() == Material.LEATHER_HELMET && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();

            if (meta.getDisplayName() != null && meta.getDisplayName().equals("Plastron du Arcanist")) {
                return true;
            }
        }
        return false;
    }
}
