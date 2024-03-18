package fr.seaskycore.caisse.lunaire.glaive;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GlaiveNoelListener {


    public static ItemStack createGlaive() {
        ItemStack GLAIVE = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = GLAIVE.getItemMeta();

        // Définir le modèle personnalisé et le nom
        meta.setCustomModelData(Integer.valueOf("10000"));
        meta.setDisplayName("§6§l✤ Glaive Lunaire ✤");
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 4, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 8, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 8, true);
        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 8, true);

        meta.setUnbreakable(true);

        meta.setLore(Arrays.asList(
                "§4Effets:",
                "§f• §fGain de §a+30$ §f à chaque",
                "§f• créature tuée"
        ));





        GLAIVE.setItemMeta(meta);

        return GLAIVE;
    }


}
