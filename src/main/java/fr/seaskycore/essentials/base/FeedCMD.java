package fr.seaskycore.essentials.base;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande peut uniquement être exécutée par un joueur.");
            return true;
        }

        Player p = (Player) sender;

        // Ajouter la vérification de permission ici
        if (!p.hasPermission("seasky.feed")) {
            p.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        if (args.length == 0) {
            p.setFoodLevel(20);
            p.sendMessage("§6Votre faim a été restaurée.");
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                target.setFoodLevel(20);
                p.sendMessage("§6La faim de §e" + target.getName() + " §6a été restaurée.");
            } else {
                p.sendMessage("§cJoueur introuvable.");
            }
        } else {
            p.sendMessage("§cUtilisation incorrecte : /feed [joueur]");
        }
        return true;
    }


}
