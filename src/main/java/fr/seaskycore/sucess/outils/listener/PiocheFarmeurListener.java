package fr.seaskycore.sucess.outils.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PiocheFarmeurListener {


    public static ItemStack createPioche() {
        ItemStack PiocheFarmeur = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = PiocheFarmeur.getItemMeta();

        meta.setCustomModelData(Integer.valueOf("10006"));
        meta.setDisplayName("§f✤ §2§lPioche du Farmeur §f✤");
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 2, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);




        meta.setLore(Arrays.asList(
        ));

        PiocheFarmeur.setItemMeta(meta);

        return PiocheFarmeur;
    }


}
