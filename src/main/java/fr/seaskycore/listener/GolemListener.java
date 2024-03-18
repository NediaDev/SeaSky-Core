package fr.seaskycore.listener;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class GolemListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        if (event.getEntityType() == EntityType.IRON_GOLEM) {

            event.getDrops().removeIf(item -> item.getType().equals(Material.POPPY));


        }


    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.IRON_GOLEM) {
            if (event.getEntity() instanceof IronGolem) {
                IronGolem ironGolem = (IronGolem) event.getEntity();

                ironGolem.setHealth(2);
            }
        }
    }






}
