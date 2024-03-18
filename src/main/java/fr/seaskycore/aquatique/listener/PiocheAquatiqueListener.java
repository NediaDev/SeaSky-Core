package fr.seaskycore.aquatique.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PiocheAquatiqueListener {

    public static ItemStack createPiocheAquatique() {
        ItemStack EQUATIQUEPIOCHE = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = EQUATIQUEPIOCHE.getItemMeta();

        // Définir le modèle personnalisé et le nom
        meta.setCustomModelData(Integer.valueOf("10005"));
        meta.setDisplayName("§f✦ §b§lPioche Aquatique §f✦");
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.DIG_SPEED, 6, true);

        meta.setUnbreakable(true);

        meta.setLore(Arrays.asList(
        ));





        EQUATIQUEPIOCHE.setItemMeta(meta);

        return EQUATIQUEPIOCHE;
    }
}
