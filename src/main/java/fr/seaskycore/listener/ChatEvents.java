package fr.seaskycore.listener;

import fr.seaskycore.permissions.Perms;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;

public class ChatEvents implements Listener
{
    @EventHandler
    public void onChat(final PlayerChatEvent e) {
        if (Perms.hasPerms(e.getPlayer())) {
            for (final Player a : Bukkit.getOnlinePlayers()) {
                e.setMessage(e.getMessage().replace(a.getName(), "§6@" + a.getName() + "§r"));
            }
        }
    }
}

