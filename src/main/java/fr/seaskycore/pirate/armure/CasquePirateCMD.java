package fr.seaskycore.pirate.armure;

import fr.seaskycore.aquatique.listener.armure.CasqueAquatiqueListener;
import fr.seaskycore.pirate.armure.listener.CasquePirateListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class CasquePirateCMD implements CommandExecutor {

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

        if (command.getName().equalsIgnoreCase("casqueapirate")) {
            if (args.length < 1 || args.length > 2) {
                sender.sendMessage("§cUtilisation incorrecte. Utilisez /casqueapirate <joueur> [quantité]");
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
                targetPlayer.getInventory().addItem(CasquePirateListener.createCasquePirate());
            }

            // Message de confirmation
            sender.sendMessage("§eVous avez donné §f" + quantity + " §cCasque Pirate à §e" + targetPlayer.getName());
            return true;
        }

        return false;
    }


}