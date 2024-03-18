package fr.seaskycore.sucess.armure.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class BotteFarmeurListener {


    public static ItemStack createBotte() {
        ItemStack casquePantalon = new ItemStack(Material.LEATHER_BOOTS);
     //   ItemMeta meta = casquePantalon.getItemMeta();
        LeatherArmorMeta meta = (LeatherArmorMeta) casquePantalon.getItemMeta();


        meta.setColor(org.bukkit.Color.fromRGB(115, 0, 255)); // 115, 0, 255
        meta.setCustomModelData(Integer.valueOf("10005"));
        meta.setDisplayName("§f✤ §2§lBotte du Farmeur §f✤");
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 8, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        meta.setLore(Arrays.asList(
                " ",
                "§aDébloque les effets suiviants :",
                "§f• Speed 1"
        ));

        casquePantalon.setItemMeta(meta);

        return casquePantalon;
    }

    public static boolean isBootFarmeur(ItemStack item) {
        if (item != null && item.getType() == Material.LEATHER_BOOTS && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();

            if (meta.getDisplayName() != null && meta.getDisplayName().equals("§f✤ §2§lBotte du Farmeur §f✤")) {
                return true;
            }
        }
        return false;
    }
}
