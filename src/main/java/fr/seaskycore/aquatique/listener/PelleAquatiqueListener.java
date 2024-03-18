package fr.seaskycore.aquatique.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PelleAquatiqueListener {


    public static ItemStack createPelleAquatique() {
        ItemStack EQUATIQUEPIOCHE = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = EQUATIQUEPIOCHE.getItemMeta();

        // Définir le modèle personnalisé et le nom
        meta.setCustomModelData(Integer.valueOf("10003"));
        meta.setDisplayName("§f✦ §b§lPelle Aquatique §f✦");
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);



        meta.setLore(Arrays.asList(
        ));





        EQUATIQUEPIOCHE.setItemMeta(meta);

        return EQUATIQUEPIOCHE;
    }
}
