package fr.seaskycore.listener;

import org.bukkit.event.Listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public class BowListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.SKELETON) {
            event.getDrops().removeIf(item -> item.getType().equals(org.bukkit.Material.BOW));
        }
    }
}