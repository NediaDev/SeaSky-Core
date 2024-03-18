package fr.seaskycore.cluescroll;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CluescrollEpiqueCommand implements CommandExecutor {
    private final Economy economy;

    public CluescrollEpiqueCommand(Economy economy) {
        this.economy = economy;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || sender.hasPermission("seasky.rare")) {
            if (args.length == 1) {
                String playerName = args[0];

                double chance = Math.random();

                Player targetPlayer = Bukkit.getPlayer(playerName);
                if (targetPlayer != null) {
                    if (chance < 0.75) {
                        // Drop entre 120000 et 145000$
                        double amount = Math.round(Math.random() * 25000) + 120000;

                        // Limitez le montant à 145000
                        if (amount > 145000) {
                            amount = 145000;
                        }

                        int numberOfKeys = 0;
                        double spawnerChance = Math.random();

                        // 75% de chance de drop entre 0 et 5 clés
                        if (spawnerChance < 0.75) {
                            numberOfKeys = (int) (Math.random() * 6);
                        }

                        // Utilisez la commande pour donner des clés au joueur
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crate give physical CaisseSucces " + numberOfKeys + " " + targetPlayer.getName());

                        // Donnez de l'argent au joueur
                        economy.depositPlayer(targetPlayer, amount);

                        targetPlayer.sendMessage("§6Vous avez reçu " + numberOfKeys + " clé(s) et §c" + amount + "§6 avec votre grimoire!");
                    } else {
                        // 5% de chance pour les spawners
                        if (chance < 0.8) {
                            String[] spawnerTypes = {"pig", "sheep", "cow", "chicken", "rabbit"};
                            String selectedSpawner = spawnerTypes[(int) (Math.random() * spawnerTypes.length)];

                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ws give " + targetPlayer.getName() + " spawner " + selectedSpawner + " 1");

                            targetPlayer.sendMessage("§6Vous avez reçu un spawner de " + selectedSpawner + " avec votre grimoire!");
                        } else {
                            // Si le nombre est supérieur ou égal à 0.8, le joueur reçoit uniquement de l'argent
                            double amount = Math.round(Math.random() * 25000) + 120000; // entre 120000 et 145000$

// Limitez le montant à 145000
                            if (amount > 145000) {
                                amount = 145000;
                            }

                            // Donnez de l'argent au joueur
                            economy.depositPlayer(targetPlayer, amount);

                            targetPlayer.sendMessage("§6Vous avez reçu §c" + amount + "§6 avec votre grimoire!");
                        }
                    }
                } else {
                    sender.sendMessage("Le joueur " + playerName + " n'est pas en ligne.");
                    return true;
                }

                return true;
            } else {
                sender.sendMessage("Usage: /cluescrollepique <player>");
                return true;
            }
        } else {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }
    }
}