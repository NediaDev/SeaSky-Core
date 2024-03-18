package fr.seaskycore.aquatique.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PecheAquatiqueListener {

    public static ItemStack createPelleAquatique() {
        ItemStack EQUATIQUEPIOCHE = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = EQUATIQUEPIOCHE.getItemMeta();

        // Définir le modèle personnalisé et le nom
   //     meta.setCustomModelData(Integer.valueOf("10003"));
        meta.setDisplayName("§f✦ §b§lCanne à pêche Aquatique §f✦");
        meta.addEnchant(Enchantment.LUCK, 4, true);
        meta.addEnchant(Enchantment.LURE, 4, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);



        meta.setLore(Arrays.asList(
        ));





        EQUATIQUEPIOCHE.setItemMeta(meta);

        return EQUATIQUEPIOCHE;
    }
}
