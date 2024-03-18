package fr.seaskycore.essentials.mod;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class EnderchestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande doit être exécutée par un joueur.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("seasky.enderchest") && !player.hasPermission("seasky.mod")) {
            player.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        if (args.length == 0) {
            player.openInventory(player.getEnderChest());
        } else if (args.length == 1 && player.hasPermission("seasky.mod")) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage("§cLe joueur spécifié n'est pas en ligne.");
                return true;
            }

            player.openInventory(target.getEnderChest());
        } else {
            player.sendMessage("§6Utilisation incorrecte. Utilisez /enderchest [joueur]");
        }

        return true;
    }

}
