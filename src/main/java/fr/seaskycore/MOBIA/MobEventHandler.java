package fr.seaskycore.MOBIA;

import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class MobEventHandler implements Listener {




    @EventHandler
    public void onEntityTarget(EntityTargetEvent event) {
        // Désactive l'IA
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        // Permet aux joueurs de tuer les mobs
        if (event.getDamager() instanceof Entity && event.getEntity() instanceof Entity) {
            Entity damager = (Entity) event.getDamager();
            Entity damaged = (Entity) event.getEntity();

            // Vérifie si le damager est un joueur
            if (damager instanceof org.bukkit.entity.Player) {
                // Autorise les dégâts causés par le joueur
                event.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void onEntityToggleSwim(EntityToggleSwimEvent event) {
        // Annule le mouvement de nage des mobs
        event.setCancelled(true);
    }

}
