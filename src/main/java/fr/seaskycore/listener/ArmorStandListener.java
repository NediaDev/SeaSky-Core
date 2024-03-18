package fr.seaskycore.listener;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ArmorStandListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof ArmorStand && event.getDamager() instanceof Player) {
            if (!((Player) event.getDamager()).hasPermission("armorstandinteraction.bypass")) {
                // Annulez l'événement si le joueur tente de causer des dégâts à un armor stand
                event.setCancelled(true);
            }
        }
    }
}
