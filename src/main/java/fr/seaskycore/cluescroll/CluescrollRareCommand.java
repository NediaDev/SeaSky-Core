package fr.seaskycore.cluescroll;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.CommandExecutor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class CluescrollRareCommand implements CommandExecutor, Listener {
    private final Economy economy;

    public CluescrollRareCommand(Economy economy) {
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
                    if (chance < 0.02) {
                        String[] spawnerTypes = {"pig", "sheep", "cow", "chicken","rabbit"};
                        String selectedSpawner = spawnerTypes[(int) (Math.random() * spawnerTypes.length)];

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ws give " + targetPlayer.getName() + " spawner " + selectedSpawner + " 1");

                        targetPlayer.sendMessage("§6Vous avez reçu un spawner de " + selectedSpawner + " avec votre grimoire!");
                    } else {
                        if (chance < 0.6) {
                            int numberOfKeys = (int) (Math.random() * 4); // entre 0 et 3 clés
                            double amount = Math.round(Math.random() * 20000) + 20000; // entre 20000 et 40000$

                            // Limitez le montant à 40000
                            if (amount > 40000) {
                                amount = 40000;
                            }

                            // Utilisez la commande pour donner des clés au joueur
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crate give physical CaisseSucces " + numberOfKeys + " " + targetPlayer.getName());

                            // Donnez de l'argent au joueur
                            economy.depositPlayer(targetPlayer, amount);

                            targetPlayer.sendMessage("§6Vous avez reçu " + numberOfKeys + " clé(s) et §c" + amount + "§6 avec votre grimoire!");
                        } else {
                            // Si le nombre est supérieur ou égal à 0.6, le joueur reçoit uniquement de l'argent
                            double amount = Math.round(Math.random() * 20000) + 20000; // entre 20000 et 40000$

                            // Limitez le montant à 40000
                            if (amount > 40000) {
                                amount = 40000;
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
                sender.sendMessage("Usage: /cluescrollrare <player>");
                return true;
            }
        } else {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }
    }
}