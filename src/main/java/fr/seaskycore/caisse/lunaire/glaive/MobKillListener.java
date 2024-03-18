package fr.seaskycore.caisse.lunaire.glaive;

import fr.seaskycore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MobKillListener implements Listener {

    private final Main plugin;

    public MobKillListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            //          Agréssif
            if (event.getEntityType() == EntityType.EVOKER
                    || event.getEntityType() == EntityType.ZOMBIE
                    || event.getEntityType() == EntityType.SKELETON
                    || event.getEntityType() == EntityType.SPIDER
                    || event.getEntityType() == EntityType.WITCH
                    || event.getEntityType() == EntityType.MAGMA_CUBE
                    || event.getEntityType() == EntityType.SLIME
                    || event.getEntityType() == EntityType.ENDERMAN
                    || event.getEntityType() == EntityType.IRON_GOLEM
                    || event.getEntityType() == EntityType.BLAZE
                    || event.getEntityType() == EntityType.CREEPER
                    || event.getEntityType() == EntityType.GUARDIAN
                    || event.getEntityType() == EntityType.SQUID

                        // Passif

                    || event.getEntityType() == EntityType.SHEEP
                    || event.getEntityType() == EntityType.COW
                    || event.getEntityType() == EntityType.CHICKEN
                    || event.getEntityType() == EntityType.RABBIT
                    || event.getEntityType() == EntityType.WOLF
                    || event.getEntityType() == EntityType.GOAT
                    || event.getEntityType() == EntityType.TURTLE
                    || event.getEntityType() == EntityType.HORSE
                    || event.getEntityType() == EntityType.TURTLE


            ) {
                Player player = event.getEntity().getKiller();

                // Vérifier si le joueur a l'item spécifique
                if (hasSpecificItem(player, "§6§l✤ Glaive Lunaire ✤")) {
                    handleMobKill(player);
                }
            }
        }
    }

    private void handleMobKill(Player player) {
        plugin.getEconomy().depositPlayer(player, 30.0);
    }

    private boolean hasSpecificItem(Player player, String itemName) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasDisplayName() && meta.getDisplayName().equals(itemName)) {
                    return true;
                }
            }
        }
        return false;
    }
}