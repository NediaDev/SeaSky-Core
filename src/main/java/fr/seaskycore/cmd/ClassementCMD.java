package fr.seaskycore.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ClassementCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Logique de la commande ici
        if (command.getName().equalsIgnoreCase("classement")) {
            // Traitement de la commande
            return true;
        }
        return false;
    }
}
