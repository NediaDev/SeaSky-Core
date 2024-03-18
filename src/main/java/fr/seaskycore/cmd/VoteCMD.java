package fr.seaskycore.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoteCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final Player p = (Player)sender;
        p.sendMessage("§6§lVotez pour nous §7- §6https://seasky-mc.fr/vote !");

        return false;
    }

}
