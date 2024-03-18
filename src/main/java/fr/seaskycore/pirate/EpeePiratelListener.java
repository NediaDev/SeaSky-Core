package fr.seaskycore.pirate;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EpeePiratelListener {

    public static ItemStack createPirateSword() {
        ItemStack GLAIVE = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = GLAIVE.getItemMeta();

        meta.setCustomModelData(Integer.valueOf("10012"));
        meta.setDisplayName("§5§l✤ Épée du Pirate  ✤");
        meta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 7, true);
        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 7, true);

        meta.setUnbreakable(true);

        meta.setLore(Arrays.asList(
                "§4Effets:",
                "§f• §fGain de §a+20$ §f à chaque",
                "§f• créature tuée"
        ));





        GLAIVE.setItemMeta(meta);

        return GLAIVE;
    }
}
