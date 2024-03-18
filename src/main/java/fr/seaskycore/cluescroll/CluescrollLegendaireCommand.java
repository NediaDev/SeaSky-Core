package fr.seaskycore.cluescroll;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CluescrollLegendaireCommand implements CommandExecutor {
    private final Economy economy;

    public CluescrollLegendaireCommand(Economy economy) {
        this.economy = economy;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || sender.hasPermission("seasky.legendaire")) {
            if (args.length == 1) {
                String playerName = args[0];

                // Utilize an object Random to generate a number between 0 and 1
                double chance = Math.random();

                Player targetPlayer = Bukkit.getPlayer(playerName);
                if (targetPlayer != null) {
                    // If the number is less than 0.15 (15% chance), the player receives a spawner
                    if (chance < 0.15) {
                        String[] spawnerTypes = {"zombie", "skeleton", "creeper", "spider"}; // Add the desired spawner types
                        String selectedSpawner = spawnerTypes[(int) (Math.random() * spawnerTypes.length)];

                        // Use the command to give a spawner to the player
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ws give " + targetPlayer.getName() + " spawner " + selectedSpawner + " 1");

                        targetPlayer.sendMessage("§6Vous avez reçu un spawner de " + selectedSpawner + " avec votre grimoire!");
                    } else {
                        // 100% chance of dropping between 0 and 9 keys
                        int numberOfKeys = (int) (Math.random() * 10);

                        // Drop between 180000 and 250000 money
                        double amount = Math.round(Math.random() * 70000) + 180000; // entre 180000 et 250000$

                        if (amount > 250000) {
                            amount = 250000;
                        }

                        // Use the command to give keys to the player
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crate give physical CaisseSucces " + numberOfKeys + " " + targetPlayer.getName());

                        // Deposit money to the player
                        economy.depositPlayer(targetPlayer, amount);

                        targetPlayer.sendMessage("§6Vous avez reçu " + numberOfKeys + " clé(s) et §c" + amount + "§6 avec votre grimoire!");
                    }
                } else {
                    sender.sendMessage("Le joueur " + playerName + " n'est pas en ligne.");
                    return true;
                }

                return true;
            } else {
                sender.sendMessage("Usage: /cluescrolllegendaire <player>");
                return true;
            }
        } else {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }
    }
}