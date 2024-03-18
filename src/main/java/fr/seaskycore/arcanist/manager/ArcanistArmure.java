package fr.seaskycore.arcanist.manager;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArcanistArmure implements Listener {

    @EventHandler
    public void onArmorEquip(final ArmorEquipEvent event) {
        final Player player = event.getPlayer();
        if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_HELMET) {
            if (event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("Casque du Arcanist")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));

            }
        }
        else if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_CHESTPLATE) {
            if (event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("Plastron du Arcanist")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2));
            }
        }
        else if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_LEGGINGS) {
            if (event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("Pantalon du Arcanist")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 2));
            }
        }
        else if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_BOOTS
                && event.getNewArmorPiece().getItemMeta() != null
                && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("Botte du Arcanist")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 1));
        }
    }

    @EventHandler
    public void onArmorUnequip(final ArmorEquipEvent event) {
        final Player player = event.getPlayer();
        if (event.getOldArmorPiece() != null && event.getOldArmorPiece().getType() == Material.LEATHER_HELMET) {
            if (event.getOldArmorPiece().getItemMeta() != null && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("Casque du Arcanist")) {
                player.removePotionEffect(PotionEffectType.REGENERATION);
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            }
        }
        else if (event.getOldArmorPiece() != null && event.getOldArmorPiece().getType() == Material.LEATHER_CHESTPLATE) {
            if (event.getOldArmorPiece().getItemMeta() != null && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("Plastron du Arcanist")) {
                player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            }
        }
        else if (event.getOldArmorPiece() != null
                && event.getOldArmorPiece().getType() == Material.LEATHER_LEGGINGS) {
            if (event.getOldArmorPiece().getItemMeta() != null
                    && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("Pantalon du Arcanist")) {
                player.removePotionEffect(PotionEffectType.SATURATION);
                player.removePotionEffect(PotionEffectType.JUMP);
            }
        }
        else if (event.getOldArmorPiece() != null
                && event.getOldArmorPiece().getType() == Material.LEATHER_BOOTS
                && event.getOldArmorPiece().getItemMeta() != null
                && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("Botte du Arcanist")) {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.removePotionEffect(PotionEffectType.ABSORPTION);
        }
    }
}
