package fr.seaskycore.sucess.outils.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EpeeFarmeurListener {


    public static ItemStack createEpee() {
        ItemStack PlastronFarmeur = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = PlastronFarmeur.getItemMeta();

        meta.setCustomModelData(Integer.valueOf("10005"));
        meta.setDisplayName("§f✤ §2§lEpee du Farmeur §f✤");
        meta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 6, true);




        meta.setLore(Arrays.asList(
        ));

        PlastronFarmeur.setItemMeta(meta);

        return PlastronFarmeur;
    }

    public static boolean isEpeeFarmeur(ItemStack item) {
        if (item != null && item.getType() == Material.LEATHER_CHESTPLATE && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();

            if (meta.getDisplayName() != null && meta.getDisplayName().equals("§f✤ §2§lPlastron du Farmeur §f✤")) {
                return true;
            }
        }
        return false;
    }
}
