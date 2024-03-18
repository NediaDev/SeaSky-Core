package fr.seaskycore.listener;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ZombieListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.ZOMBIE) {

            event.getDrops().removeIf(item -> item.getType().equals(Material.IRON_SWORD));
            event.getDrops().removeIf(item -> item.getType().equals(Material.IRON_SHOVEL));

        }


    }
}
