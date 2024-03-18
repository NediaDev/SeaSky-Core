package fr.seaskycore.sucess.outils.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PelleFarmeurListener {


    public static ItemStack createPelle() {
        ItemStack PelleFarmeur = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta meta = PelleFarmeur.getItemMeta();

        meta.setCustomModelData(Integer.valueOf("10003"));
        meta.setDisplayName("§f✤ §2§lPelle du Farmeur §f✤");
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);




        meta.setLore(Arrays.asList(
        ));

        PelleFarmeur.setItemMeta(meta);

        return PelleFarmeur;
    }
}
