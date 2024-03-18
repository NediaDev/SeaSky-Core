package fr.seaskycore.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

public class CactusGrowthListener implements Listener {

    @EventHandler
    public void onCactusGrow(BlockGrowEvent event) {
        if (event.getNewState().getType() == Material.CACTUS) {
            // Annuler l'événement pour empêcher la croissance des cactus
            event.setCancelled(true);
        }
    }
}
