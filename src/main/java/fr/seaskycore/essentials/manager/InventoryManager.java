package fr.seaskycore.essentials.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InventoryManager {

    private static final Map<UUID, Inventory> enderchestInventories = new HashMap<>();

    public static Inventory getEnderChestInventory(UUID playerUUID) {
        if (enderchestInventories.containsKey(playerUUID)) {
            return enderchestInventories.get(playerUUID);
        }

        Player onlinePlayer = Bukkit.getPlayer(playerUUID);

        if (onlinePlayer != null) {
            // Le joueur est en ligne, utilisez simplement son EnderChest
            return onlinePlayer.getEnderChest();
        } else {
            // Le joueur est hors ligne, utilisez un inventaire virtuel
            Inventory enderchestInventory = Bukkit.createInventory(null, 27, "EnderChest"); // Nom de l'inventaire à votre choix

            // Obtenez les données de l'EnderChest du joueur déconnecté à partir du stockage (base de données, fichier, etc.)
            // Remplissez l'inventaire virtuel avec ces données

            enderchestInventories.put(playerUUID, enderchestInventory);
            return enderchestInventory;
        }
    }
}
