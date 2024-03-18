package fr.seaskycore.pirate.armure;

import fr.seaskycore.pirate.armure.listener.BottePirateListener;
import fr.seaskycore.pirate.armure.listener.PantalonPirateListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class BottePirateCMD implements CommandExecutor {

    private final Permission givePelleNoelPermission = new Permission("seasky.sucess");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) && !(sender instanceof ConsoleCommandSender)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur ou depuis la console.");
            return true;
        }

        if (sender instanceof Player && !sender.hasPermission(givePelleNoelPermission)) {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("botteapirate")) {
            if (args.length < 1 || args.length > 2) {
                sender.sendMessage("§cUtilisation incorrecte. Utilisez /botteapirate <joueur> [quantité]");
                return true;
            }

            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if (targetPlayer == null) {
                sender.sendMessage("§cLe joueur spécifié n'est pas en ligne.");
                return true;
            }

            int quantity = 1;
            if (args.length == 2) {
                try {
                    quantity = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    sender.sendMessage("§cLa quantité doit être un nombre entier.");
                    return true;
                }
            }

            // Ajoutez les Glaives de Noël au joueur cible
            for (int i = 0; i < quantity; i++) {
                targetPlayer.getInventory().addItem(BottePirateListener.createBottePirate());
            }

            // Message de confirmation
            sender.sendMessage("§eVous avez donné §f" + quantity + " §cPantalon Pirate à §e" + targetPlayer.getName());
            return true;
        }

        return false;
    }
}
