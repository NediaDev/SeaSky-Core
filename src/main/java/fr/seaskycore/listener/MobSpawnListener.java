package fr.seaskycore.listener;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobSpawnListener implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL) {
            if (event.getLocation().getBlock().getState() instanceof CreatureSpawner) {
                CreatureSpawner spawner = (CreatureSpawner) event.getLocation().getBlock().getState();
                EntityType spawnerEntityType = spawner.getSpawnedType();

                // Vous pouvez ajouter d'autres vérifications ici en fonction du type d'entité du spawner
                if (event.getEntityType() == spawnerEntityType) {
                    // Autorise le spawn si l'entité du spawner correspond à l'entité du spawn
                    return;
                }
            }

            // Annule le spawn si ce n'est pas un spawn de spawner ou si les conditions ne sont pas remplies
            event.setCancelled(true);
        }
        // Vous pouvez ajouter d'autres conditions ici pour permettre le spawn basé sur d'autres raisons
    }
}
