package fr.seaskycore.listener;

import org.bukkit.event.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase();

        // Vérifier si la commande est /ah sell ou /hdv sell
        if (command.startsWith("/ah sell") || command.startsWith("/hdv sell")) {
            // Vérifier si l'item dans la main est "Menu Principal" (player_head)
            if (player.getInventory().getItemInMainHand().getType().toString().equals("PLAYER_HEAD")
                    && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§e§lMenu Principal")) {
                // Annuler l'événement pour empêcher la vente
                event.setCancelled(true);
                player.sendMessage("§cVous ne pouvez pas vendre cet item!");
            }
        }
    }
}
