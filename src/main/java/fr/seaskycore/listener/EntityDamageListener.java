package fr.seaskycore.listener;

import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Skeleton) {
            Skeleton golem = (Skeleton) event.getEntity();
            // Réduire la vie du golem à 7 cœurs
            golem.setHealth(1);
        }
    }

/*    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Entity && event.getEntity() instanceof Entity) {
            Entity damager = (Entity) event.getDamager();
            Entity damaged = (Entity) event.getEntity();

            // Liste des types d'entités à mettre à 1HP
            EntityType[] entitiesToSetOneHP = {
                    EntityType.PIG,
                    EntityType.SHEEP,
                    EntityType.CHICKEN,
                    EntityType.COW,
                    EntityType.RABBIT,
                    EntityType.ZOMBIE,
                    EntityType.SKELETON,
                    EntityType.SPIDER,
                    EntityType.CREEPER,
                    EntityType.SLIME,
                    EntityType.MAGMA_CUBE,
                    EntityType.BLAZE,
                    EntityType.SQUID,
                    EntityType.WITCH,
                    EntityType.GUARDIAN,
                    EntityType.ZOMBIFIED_PIGLIN,
                    EntityType.ENDERMAN,
                    EntityType.EVOKER,

            };

            for (EntityType entityType : entitiesToSetOneHP) {
                if (damaged.getType() == entityType && damaged instanceof LivingEntity) {
                    LivingEntity livingDamaged = (LivingEntity) damaged;

                    if (livingDamaged.getHealth() - event.getFinalDamage() <= 0) {
                        // Mettez l'entité à 1HP
                        livingDamaged.setHealth(1);
                    }
                }
            }
        }
    }*/
}
