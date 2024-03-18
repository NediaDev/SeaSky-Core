package fr.seaskycore.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoCropJump implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL && event.getClickedBlock() != null) {
            Material clickedMaterial = event.getClickedBlock().getType();
            if (isCrop(clickedMaterial)) {
                event.setCancelled(true);
            }
        }
    }

    private boolean isCrop(Material material) {
        return material == Material.CARROTS || material == Material.POTATOES ||
                material == Material.WHEAT || material == Material.BEETROOTS ||
                material == Material.WHEAT_SEEDS || material == Material.BEETROOT_SEEDS ||
                material == Material.MELON_SEEDS || material == Material.PUMPKIN_SEEDS;
    }
}
