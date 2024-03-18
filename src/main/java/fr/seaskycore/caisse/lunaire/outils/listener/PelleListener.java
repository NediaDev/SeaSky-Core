package fr.seaskycore.caisse.lunaire.outils.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PelleListener {

    public static ItemStack createPelle() {
        ItemStack GLAIVE = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = GLAIVE.getItemMeta();

        // Définir le modèle personnalisé et le nom
        meta.setCustomModelData(Integer.valueOf("10000"));
        meta.setDisplayName("§6§l✤ Pelle Lunaire ✤");
        meta.addEnchant(Enchantment.DIG_SPEED, 7, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        meta.setUnbreakable(true);



        meta.setUnbreakable(true);

        meta.setLore(Arrays.asList(
        ));





        GLAIVE.setItemMeta(meta);

        return GLAIVE;
    }
}
