package fr.seaskycore.aquatique.listener.armure;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;


    public class PantalonAquatiqueListener {

        public static ItemStack createPantalonAquatique() {
            ItemStack CasqueAquatique = new ItemStack(Material.LEATHER_LEGGINGS);

            LeatherArmorMeta meta = (LeatherArmorMeta) CasqueAquatique.getItemMeta();


            meta.setColor(org.bukkit.Color.fromRGB(80, 255, 236)); // 80, 255, 236

            // Définir le modèle personnalisé et le nom
            meta.setCustomModelData(Integer.valueOf("10001"));
            meta.setDisplayName("§f✦ §b§lPantalon Aquatique §f✦");
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);

            meta.setUnbreakable(true);

            meta.setLore(Arrays.asList(
            ));





            CasqueAquatique.setItemMeta(meta);

            return CasqueAquatique;

}

}
