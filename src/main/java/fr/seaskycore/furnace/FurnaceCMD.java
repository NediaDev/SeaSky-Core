package fr.seaskycore.furnace;

import fr.seaskycore.furnace.cook.Cook;

import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

public class FurnaceCMD implements CommandExecutor
{
    private Cook cook;

    public FurnaceCMD(final Cook cook1) {
        this.cook = cook1;
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;

            // Vérification des permissions
            if (label.equals("furnace") || label.equals("furn")) {
                if (!player.hasPermission("seasky.furnace.use")) {
                    player.sendMessage("§cVous n'avez pas la permission d'utiliser /furnace.");
                    return true;
                }

                ItemStack itemInHand = player.getInventory().getItemInMainHand();
                if (itemInHand.getType() == Material.AIR) {
                    player.sendMessage("§cVous n'avez rien dans votre main. Placez un objet à cuire dans votre main.");
                    return true;
                }

                this.cook.cookItemInHand(player);
            } else if (label.equals("furnaceall") || label.equals("furnall")) {
                if (!player.hasPermission("seasky.furnace.all")) {
                    player.sendMessage("§cVous n'avez pas la permission d'utiliser /furnaceall.");
                    return true;
                }

                if (player.getInventory().isEmpty()) {
                    player.sendMessage("§cVotre inventaire est vide. Placez des objets à cuire dans votre inventaire.");
                    return true;
                }

                this.cook.cookAllItemsInInventory(player);
            }
        } else {
            sender.sendMessage("§cCette commande est réservée aux joueurs.");
        }
        return false;
    }
}
