package fr.seaskycore.listener.armure.farm;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FarmArmure implements Listener {


    @EventHandler
    public void onArmorEquip(final ArmorEquipEvent event) {
        final Player player = event.getPlayer();
        if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_HELMET) {
            if (event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("§f✤ §2§lCasque du Farmeur §f✤")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));

            }
        }
        else if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_CHESTPLATE) {
            if (event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("§f✤ §2§lPlastron du Farmeur §f✤")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 0));
            }
        }
        else if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_LEGGINGS) {
            if (event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("§f✤ §2§lPantalon du Farmeur §f✤")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
            }
        }
        else if (event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() == Material.LEATHER_BOOTS && event.getNewArmorPiece().getItemMeta() != null && event.getNewArmorPiece().getItemMeta().getDisplayName().equals("§f✤ §2§lBotte du Farmeur §f✤")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
        }
    }

    @EventHandler
    public void onArmorUnequip(final ArmorEquipEvent event) {
        final Player player = event.getPlayer();
        if (event.getOldArmorPiece() != null && event.getOldArmorPiece().getType() == Material.LEATHER_HELMET) {
            if (event.getOldArmorPiece().getItemMeta() != null && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("§f✤ §2§lCasque du Farmeur §f✤")) {
                player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
            }
        }
        else if (event.getOldArmorPiece() != null && event.getOldArmorPiece().getType() == Material.LEATHER_CHESTPLATE) {
            if (event.getOldArmorPiece().getItemMeta() != null && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("§f✤ §2§lPlastron du Farmeur §f✤")) {
                player.removePotionEffect(PotionEffectType.SATURATION);
            }
        }
        else if (event.getOldArmorPiece() != null
                && event.getOldArmorPiece().getType() == Material.LEATHER_LEGGINGS) {
            if (event.getOldArmorPiece().getItemMeta() != null
                    && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("§f✤ §2§lPantalon du Farmeur §f✤")) {
                player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
            }
        }
        else if (event.getOldArmorPiece() != null
                && event.getOldArmorPiece().getType() == Material.LEATHER_BOOTS
                && event.getOldArmorPiece().getItemMeta() != null
                && event.getOldArmorPiece().getItemMeta().getDisplayName().equals("§f✤ §2§lBotte du Farmeur §f✤")) {
            player.removePotionEffect(PotionEffectType.SPEED);
        }
    }
}
