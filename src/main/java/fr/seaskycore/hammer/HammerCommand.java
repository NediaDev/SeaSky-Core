package fr.seaskycore.hammer;

import fr.seaskycore.Main;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import java.util.*;

public class HammerCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final String command = "givehammer";
        if (label.equalsIgnoreCase(command)) {
            if (sender.hasPermission("astralitems.give")) {
                final ItemStack theItem = getHammer();
                final ItemMeta theItemM = theItem.getItemMeta();
                final ArrayList<String> lore = new ArrayList<String>(theItemM.getLore());
                theItemM.setLore((List)lore);
                theItem.setItemMeta(theItemM);
                final boolean isNotStackableItem = true;
                int amount = 1;
                if (args.length >= 1) {
                    try {
                        amount = Integer.parseInt(args[0]);
                    }
                    catch (NumberFormatException e) {
                        sender.sendMessage("§cLa quantit\u00e9 indiqu\u00e9 n'est pas un nombre valide!");
                        sender.sendMessage("§7La quantit\u00e9 a donc \u00e9t\u00e9 mis \u00e0 1");
                    }
                }
                if (args.length <= 1) {
                    if (sender instanceof Player) {
                        final Player player = (Player)sender;
                        if (args.length == 0) {
                            final HashMap<Integer, ItemStack> invFull = (HashMap<Integer, ItemStack>)player.getInventory().addItem(new ItemStack[] { theItem });
                            Main.invFullToDrop(invFull, player);
                            player.sendMessage("§7Vous venez de recevoir " + amount + "x " + theItem.getItemMeta().getDisplayName());
                            return true;
                        }
                        if (args.length == 1) {
                            final ItemStack item = new ItemStack(theItem);
                            item.setAmount(amount);
                            if (isNotStackableItem) {
                                for (int i = 0; i < amount; ++i) {
                                    final HashMap<Integer, ItemStack> invFull2 = (HashMap<Integer, ItemStack>)player.getInventory().addItem(new ItemStack[] { theItem });
                                    Main.invFullToDrop(invFull2, player);
                                }
                                player.sendMessage("§7Vous venez de recevoir " + amount + "x " + theItem.getItemMeta().getDisplayName());
                            }
                            else {
                                final HashMap<Integer, ItemStack> invFull3 = (HashMap<Integer, ItemStack>)player.getInventory().addItem(new ItemStack[] { item });
                                Main.invFullToDrop(invFull3, player);
                                player.sendMessage("§7Vous venez de recevoir " + amount + "x " + theItem.getItemMeta().getDisplayName());
                            }
                            return true;
                        }
                    }
                    else {
                        sender.sendMessage("§cVous devez \u00eatre un joueur pour effectuer cette commande!");
                        sender.sendMessage("§7Essayer plut\u00f4t /" + command + " [Quantit\u00e9] [NomDuJoueur]");
                    }
                }
                else {
                    for (final Player p : Bukkit.getOnlinePlayers()) {
                        if (p.getName().equals(args[1])) {
                            final ItemStack item2 = new ItemStack(theItem);
                            item2.setAmount(amount);
                            if (isNotStackableItem) {
                                for (int j = 0; j < amount; ++j) {
                                    final HashMap<Integer, ItemStack> invFull4 = (HashMap<Integer, ItemStack>)p.getInventory().addItem(new ItemStack[] { theItem });
                                    Main.invFullToDrop(invFull4, p);
                                }
                                p.sendMessage("§7Vous venez de recevoir " + amount + "x " + theItem.getItemMeta().getDisplayName());
                            }
                            else {
                                final HashMap<Integer, ItemStack> invFull2 = (HashMap<Integer, ItemStack>)p.getInventory().addItem(new ItemStack[] { item2 });
                                Main.invFullToDrop(invFull2, p);
                                p.sendMessage("§7Vous venez de recevoir " + amount + "x " + theItem.getItemMeta().getDisplayName());
                            }
                            return true;
                        }
                    }
                    sender.sendMessage("§cCe joueur n'est pas connect\u00e9 !");
                }
            }
            else {
                sender.sendMessage("§cVous n'avez pas la permission d'effectuer cette commande!");
            }
            return true;
        }
        return false;
    }

    private ItemStack getHammer() {
        return null;
    }


}

