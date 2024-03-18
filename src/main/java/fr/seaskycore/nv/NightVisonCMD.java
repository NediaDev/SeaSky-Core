package fr.seaskycore.nv;

import fr.seaskycore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisonCMD implements CommandExecutor {
    private Main main;

    public NightVisonCMD(final Main main) {
        this.main = main;
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final Player p = (Player)sender;

        if (args.length != 1) {
            p.sendMessage("§c/vision <on/off>.");
            return false;
        }
        if ("on".equalsIgnoreCase(args[0])) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1));
            p.sendMessage("§eVision nocturne §aactivé.");
        }
        else {
            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
            p.sendMessage("§eVision nocturne §cdésactivé.");
        }
        return true;
    }
}
