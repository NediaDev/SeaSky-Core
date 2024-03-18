package fr.seaskycore.essentials.mod;

import fr.seaskycore.Main;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class CommandSudo implements CommandExecutor
{
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] args) {
        try {
            if (args.length < 2) {
                return false;
            }
            final Player target = Bukkit.getPlayer(args[0]);
            String message = "";
            for (int i = 1; i < args.length; ++i) {
                message = message + args[i].replace("&", "§") + " ";
            }
            target.chat(message.toString());
            commandSender.sendMessage("§6Vous avez forcé §a" + target.getName() + " §6a éxécuter la commande §c" + message.toString());
        }
        catch (Exception e) {
            Main.printErrorMessage(commandSender, e);
        }
        return false;
    }
}
