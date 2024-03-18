package fr.seaskycore.cluescroll;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.CommandExecutor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class CluescrollCommand implements CommandExecutor, Listener {
    private final Economy economy;

    public CluescrollCommand(Economy economy) {
        this.economy = economy;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || sender.hasPermission("seasky.commun")) {
            if (args.length == 1) {
                String playerName = args[0];

                // Utilisez un objet Random pour générer un nombre entre 0 et 1
                double chance = Math.random();

                Player targetPlayer = Bukkit.getPlayer(playerName);
                if (targetPlayer != null) {
                    // Définissez les pourcentages de clés et d'argent
                    double keyPercentage = 0.5; // 50% de chance de clé
                    double moneyPercentage = 0.6; // 60% de chance d'argent

                    // Vérifiez le résultat pour déterminer la récompense
                    if (chance < keyPercentage) {
                        int numberOfKeys = (int) (Math.random() * 2); // entre 0 et 1 clé
                        double amount = Math.round(Math.random() * 10000) + 5000; // entre 5000 et 15000$

                        // Limitez le montant à 15000
                        if (amount > 15000) {
                            amount = 15000;
                        }

                        // Utilisez la commande pour donner des clés au joueur
                          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crate give physical CaisseSucces " + numberOfKeys + " " + targetPlayer.getName());

                        // Donnez de l'argent au joueur
                        economy.depositPlayer(targetPlayer, amount);

                        targetPlayer.sendMessage("§6Vous avez reçu " + numberOfKeys + " clé(s) et §c" + amount + "§6 avec votre grimoire !");
                    } else {
                        // Si le résultat est supérieur au pourcentage de clés, le joueur reçoit uniquement de l'argent
                        double amount = Math.round(Math.random() * 10000) + 5000; // entre 5000 et 15000$

                        // Limitez le montant à 15000
                        if (amount > 15000) {
                            amount = 15000;
                        }

                        // Donnez de l'argent au joueur
                        economy.depositPlayer(targetPlayer, amount);

                        targetPlayer.sendMessage("§6Vous avez reçu §c" + amount + "§6 avec votre grimoire !");
                    }
                } else {
                    sender.sendMessage("Le joueur " + playerName + " n'est pas en ligne.");
                    return true;
                }

                return true;
            } else {
                sender.sendMessage("Usage: /cluescrollcomun <player>");
                return true;
            }
        } else {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }
    }
}