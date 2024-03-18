package fr.seaskycore.essentials.cmd;

import fr.seaskycore.Main;
import org.bukkit.entity.*;
import org.bukkit.command.*;

public abstract class CMD
{
    protected final Main plugin;

    public CMD() {
        this.plugin = Main.getInstance();
    }

    protected abstract boolean onCommand(final Player p0, final Command p1, final String p2, final String[] p3);

    protected abstract String getPermission();
}

