package fr.seaskycore.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Guardian;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class GuardianListener implements Listener {

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Guardian) {
            // Désactivez l'IA du gardien
            ((Guardian) entity).setAI(false);

            // Ajoutez la gravité au gardien
            entity.setGravity(false);
        }
    }
}
