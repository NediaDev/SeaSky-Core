package fr.seaskycore.furnace.manage;

import fr.seaskycore.Main;
import org.bukkit.*;

public class Manage
{
    private Main instance;
    private Manage manage;

    public void load(final Main furnace) {
        this.instance = this.instance;
        this.manage = this;
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "----------------------------");
        System.out.println(" ");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "          SeaSkyCore");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "         V : 1.0");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "               By : NediaChicha (Loxuh)");
        System.out.println(" ");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "----------------------------");
    }

    public Main getInstance() {
        return this.instance;
    }

    public Manage getManage() {
        return this.manage;
    }
}

