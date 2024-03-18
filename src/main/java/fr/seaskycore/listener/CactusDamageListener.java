package fr.seaskycore.listener;

import org.bukkit.event.Listener;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByBlockEvent;

// Classe écouteur pour les dégâts des cactus
public class CactusDamageListener implements Listener {

    @EventHandler
    public void onCactusDamage(EntityDamageByBlockEvent event) {
        // Vérifie si l'entité endommagée est un joueur
        Entity entity = event.getEntity();
        if (entity instanceof org.bukkit.entity.Player) {
            // Vérifie si les dégâts sont causés par un cactus (Material.CACTUS)
            if (event.getDamager().getType().name().equals("CACTUS")) {
                // Annule les dégâts
                event.setCancelled(true);
            }
        }
    }


}