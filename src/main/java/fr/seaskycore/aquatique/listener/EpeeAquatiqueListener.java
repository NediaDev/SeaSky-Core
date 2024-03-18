package fr.seaskycore.aquatique.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EpeeAquatiqueListener {


    public static ItemStack createEpeeAquatique() {
        ItemStack EQUATIQUE = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = EQUATIQUE.getItemMeta();

        // Définir le modèle personnalisé et le nom
        meta.setCustomModelData(Integer.valueOf("10014"));
        meta.setDisplayName("§f✦ §b§lÉpée Aquatique §f✦");
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 7, true);

        meta.setUnbreakable(true);

        meta.setLore(Arrays.asList(
                "§4Effets:",
                "§f• §fGain de §a10$ §fà chaque",
                "§f• créature tuées."
        ));





        EQUATIQUE.setItemMeta(meta);

        return EQUATIQUE;
    }
}
