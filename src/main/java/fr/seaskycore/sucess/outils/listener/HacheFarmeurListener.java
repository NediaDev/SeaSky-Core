package fr.seaskycore.sucess.outils.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class HacheFarmeurListener {


    public static ItemStack createHache() {
        ItemStack HacheFarmeur = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = HacheFarmeur.getItemMeta();

        meta.setCustomModelData(Integer.valueOf("10003"));
        meta.setDisplayName("§f✤ §2§lHache du Farmeur §f✤");
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);




        meta.setLore(Arrays.asList(
        ));

        HacheFarmeur.setItemMeta(meta);

        return HacheFarmeur;
    }
}
