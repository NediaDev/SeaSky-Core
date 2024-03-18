package fr.seaskycore.poubelles;

import fr.seaskycore.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class PoubelleCommand implements CommandExecutor {

    private Main main;
    private Inventory inv;

    public PoubelleCommand(final Main main) {
        this.main = main;
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (sender instanceof Player) {
            if (label.equalsIgnoreCase("poubelle") || label.equalsIgnoreCase("majid") || label.equalsIgnoreCase("trash")) {
                if (args.length == 0) {
                    this.Trash(p);
                }
                else {
                    p.sendMessage("&cUse: /poubelle");
                }
            }
        }
        else {
            sender.sendMessage("§cQue les joueurs peuvent utilisé la commande !!");
        }
        return true;
    }

    public void Trash(final Player p) {
        p.openInventory(this.inv = Bukkit.createInventory((InventoryHolder)null, 54, "§cPoubelle"));
    }
}