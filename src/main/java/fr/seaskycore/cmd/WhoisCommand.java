package fr.seaskycore.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WhoisCommand implements CommandExecutor {


    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if ((sender.hasPermission("whois.seasky") || sender.isOp()) && command.getName().equalsIgnoreCase("whois")) {
            if (args.length == 1) {
                final String playerName = args[0];
                final Player player = Bukkit.getPlayer(playerName);
                if (player == null) {
                    sender.sendMessage(ChatColor.RED + "Le joueur n'est pas connecté.");
                    return true;
                }

                String worldName = player.getWorld().getName();
                String locationInfo;

                if ("world".equals(worldName)) {
                    locationInfo = ChatColor.YELLOW + " Localisation: " + ChatColor.GOLD + "Spawn";
                } else if ("SuperiorWorld".equals(worldName)) {
                    locationInfo = ChatColor.YELLOW + " Localisation: " + ChatColor.GOLD + "Îles";
                } else {
                    locationInfo = ChatColor.YELLOW + " Localisation: " + ChatColor.GOLD + "Monde inconnu";
                }

                final String[] whois = {
                        ChatColor.GOLD + player.getName() + ChatColor.YELLOW + " Info :",
                        ChatColor.YELLOW + " UUID: " + ChatColor.GOLD + player.getUniqueId(),
                        ChatColor.YELLOW + " Gamemode: " + ChatColor.GOLD + player.getGameMode().toString(),
                        ChatColor.YELLOW + " Heal: " + ChatColor.GOLD + player.getHealth() + "/" + player.getMaxHealth(),
                        ChatColor.YELLOW + " Nourriture: " + ChatColor.GOLD + player.getFoodLevel() + "/20",
                        ChatColor.YELLOW + " Experience: " + ChatColor.GOLD + player.getExp(),
                        ChatColor.YELLOW + " Level: " + ChatColor.GOLD + player.getLevel(),
                        locationInfo,
                };
                sender.sendMessage(whois);
            } else {
                sender.sendMessage(ChatColor.RED + "Syntaxe: /whois <username>");
            }
        }
        return true;
    }

    private String formatDate(long timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(new Date(timestamp));
    }
}

