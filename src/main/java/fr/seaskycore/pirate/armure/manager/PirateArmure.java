package fr.seaskycore.pirate.armure.manager;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PirateArmure implements Listener {


    @EventHandler
    public void onArmorEquip(final ArmorEquipEvent event) {
        final Player player = event.getPlayer();
        if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_HELMET) {
            if (event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("§5§l✤ Casque du Pirate ✤")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1));

            }
        }
        else if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_CHESTPLATE) {
            if (event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("§5§l✤ Plastron du Pirate ✤")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 1));
            }
        }
        else if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_LEGGINGS) {
            if (event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("§5§l✤ Pantalon du Pirate ✤")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 0));
            }
        }
        else if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_BOOTS && event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("§5§l✤ Botte du Pirate ✤")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
        }
    }

    @EventHandler
    public void onArmorUnequip(final ArmorEquipEvent event) {
        final Player player = event.getPlayer();
        if (event.getOldArmorPiece() != null && event.getOldArmorPiece().getType() == Material.LEATHER_HELMET) {
            if (event.getOldArmorPiece().getItemMeta() != null && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("§5§l✤ Casque du Pirate ✤")) {
                player.removePotionEffect(PotionEffectType.REGENERATION);
            }
        }
        else if (event.getOldArmorPiece() != null && event.getOldArmorPiece().getType() == Material.LEATHER_CHESTPLATE) {
            if (event.getOldArmorPiece().getItemMeta() != null && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("§5§l✤ Plastron du Pirate ✤")) {
                player.removePotionEffect(PotionEffectType.FAST_DIGGING);
            }
        }
        else if (event.getOldArmorPiece() != null
                && event.getOldArmorPiece().getType() == Material.LEATHER_LEGGINGS) {
            if (event.getOldArmorPiece().getItemMeta() != null
                    && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("§5§l✤ Pantalon du Pirate ✤")) {
                player.removePotionEffect(PotionEffectType.SATURATION);
            }
        }
        else if (event.getOldArmorPiece() != null
                && event.getOldArmorPiece().getType() == Material.LEATHER_BOOTS
                && event.getOldArmorPiece().getItemMeta() != null
                && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("§5§l✤ Botte du Pirate ✤")) {
            player.removePotionEffect(PotionEffectType.SPEED);
        }
    }
}
