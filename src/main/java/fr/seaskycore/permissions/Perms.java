package fr.seaskycore.permissions;

import org.bukkit.configuration.file.*;
import java.io.*;
import org.bukkit.entity.*;

public class Perms
{
    private static File folder;
    private static File file;
    private static YamlConfiguration cfg;

    static {
        Perms.folder = new File("plugins/SeaCore/permissions/");
        Perms.file = new File(String.valueOf(Perms.folder.getPath()) + "/permissions.yml");
        Perms.cfg = YamlConfiguration.loadConfiguration(Perms.file);
    }

    public static void setup() {
        if (!Perms.folder.exists()) {
            Perms.folder.mkdir();
        }
        if (!Perms.file.exists()) {
            try {
                Perms.file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            writeDefault();
        }
    }

    private static void writeDefault() {
        println("ping", "seasky.ping");
    }

    public static void println(final String msg0, final String msg1) {
        Perms.cfg.set(msg0, (Object)msg1);
        try {
            Perms.cfg.save(Perms.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean hasPerms(final Player p) {
        return p.hasPermission(Perms.cfg.getString("ping"));
    }
}
