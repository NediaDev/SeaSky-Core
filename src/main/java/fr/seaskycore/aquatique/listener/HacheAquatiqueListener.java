package fr.seaskycore.aquatique.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class HacheAquatiqueListener {


    public static ItemStack createHacheAquatique() {
        ItemStack EQUATIQUEHACHE = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = EQUATIQUEHACHE.getItemMeta();

        // Définir le modèle personnalisé et le nom
        meta.setCustomModelData(Integer.valueOf("10003"));
        meta.setDisplayName("§f✦ §b§lHache Aquatique §f✦");
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.DIG_SPEED, 6, true);

        meta.setUnbreakable(true);

        meta.setLore(Arrays.asList(
        ));





        EQUATIQUEHACHE.setItemMeta(meta);

        return EQUATIQUEHACHE;
    }
}
