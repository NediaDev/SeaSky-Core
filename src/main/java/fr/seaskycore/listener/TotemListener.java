package fr.seaskycore.listener;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Evoker;
import org.bukkit.event.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public class TotemListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType() == EntityType.EVOKER) {
            Evoker evoker = (Evoker) entity;

            event.getDrops().removeIf(item -> item.getType().equals(Material.TOTEM_OF_UNDYING));
            event.getDrops().removeIf(item -> item.getType().equals(Material.WHITE_BANNER));
            event.getDrops().removeIf(item -> item.getType().equals(Material.ENDER_PEARL));

        }
    }

}
