package fr.seaskycore.essentials.admin;

import fr.seaskycore.Main;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;

public class CommandGamemode implements TabExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
        try {
            if (sender instanceof Player) {
                final Player player = (Player)sender;
                if (args.length == 0) {
                    final String name = cmd.getName();
                    switch (name) {
                        case "gms": {
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage("§6Votre gamemode a été changé en mode §csurvie");
                            break;
                        }
                        case "gmc": {
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage("§6Votre gamemode a été changé en mode §ccreatif");
                            break;
                        }
                        case "gma": {
                            player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage("§6Votre gamemode a été changé en mode §caventure");
                            break;
                        }
                        case "gmsp": {
                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage("§6Votre gamemode a été changé en mode §cspectateur");
                            break;
                        }
                    }
                }
                else if (args.length == 1) {
                    final Player target = Bukkit.getPlayer(args[0]);
                    if (player != target) {
                        final String name2 = cmd.getName();
                        switch (name2) {
                            case "gms": {
                                target.setGameMode(GameMode.SURVIVAL);
                                target.sendMessage("§6Votre gamemode a été changé en mode §csurvie");
                                player.sendMessage("§6Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §csurvie");
                                break;
                            }
                            case "gmc": {
                                target.setGameMode(GameMode.CREATIVE);
                                target.sendMessage("§6Votre gamemode a été changé en mode §ccréatif");
                                player.sendMessage("§6Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §ccréatif");
                                break;
                            }
                            case "gma": {
                                target.setGameMode(GameMode.ADVENTURE);
                                target.sendMessage("§6Votre gamemode a été changé en mode §caventure");
                                player.sendMessage("§6Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §caventure");
                                break;
                            }
                            case "gmsp": {
                                target.setGameMode(GameMode.SPECTATOR);
                                target.sendMessage("§6Votre gamemode a été changé en mode §cspectateur");
                                player.sendMessage("§6Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §cspectateur");
                                break;
                            }
                        }
                    }
                    else {
                        player.sendMessage("§cC'est pas un peu idiot de vouloir changer son propre gamemode avec un argument en trop \n" + "§4Syntaxe: /gm<c/s/sp/a>");
                    }
                }
                if (cmd.getName().equals("gamemode")) {
                    if (args.length == 1) {
                        final String s = args[0];
                        switch (s) {
                            case "creative":
                            case "c": {
                                player.setGameMode(GameMode.CREATIVE);
                                player.sendMessage("§6Votre gamemode a été changé en mode §ccréatif");
                                break;
                            }
                            case "survival":
                            case "s": {
                                player.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage("§6Votre gamemode a été changé en mode §csurvie");
                                break;
                            }
                            case "adventure":
                            case "a": {
                                player.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage("§6Votre gamemode a été changé en mode §caventure");
                                break;
                            }
                            case "spectator":
                            case "sp": {
                                player.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage("§6Votre gamemode a été changé en mode §cspectateur");
                                break;
                            }
                            default: {
                                player.sendMessage(" §4§lDésolé, mais votre syntaxe est mauvaise : /gamemode <c/s/sp/a>");
                                break;
                            }
                        }
                    }
                    else if (args.length == 2) {
                        final Player target = Bukkit.getPlayer(args[1]);
                        if (target != player) {
                            final String s2 = args[0];
                            switch (s2) {
                                case "creative":
                                case "c": {
                                    target.setGameMode(GameMode.CREATIVE);
                                    player.sendMessage("§6Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §ccréatif");
                                    target.sendMessage("§6Votre gamemode a été changé en mode §ccréatif");
                                    break;
                                }
                                case "survival":
                                case "s": {
                                    target.setGameMode(GameMode.SURVIVAL);
                                    target.sendMessage("§6Votre gamemode a été changé en mode §csurvie");
                                    player.sendMessage("§6Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §csurvie");
                                    break;
                                }
                                case "adventure":
                                case "a": {
                                    target.setGameMode(GameMode.ADVENTURE);
                                    target.sendMessage("§6Votre gamemode a été changé en mode §caventure");
                                    player.sendMessage("§6Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §caventure");
                                    break;
                                }
                                case "spectator":
                                case "sp": {
                                    target.setGameMode(GameMode.SPECTATOR);
                                    target.sendMessage("§6Votre gamemode a été changé en mode §cspectateur");
                                    player.sendMessage("§6Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §cspectateur");
                                    break;
                                }
                                default: {
                                    player.sendMessage(" §4§lDésolé, mais votre syntaxe est mauvaise : /gamemode <c/s/sp/a> (Joueur cible)");
                                    break;
                                }
                            }
                        }
                        else {
                            player.sendMessage("§cC'est pas un peu idiot de vouloir changer son propre gamemode avec un argument en trop \n" + "§4Syntaxe: /gamemode <c/s/sp/a>");
                        }
                    }
                }
            }
            else {
                sender.sendMessage("§cVous n'êtes pas joueur");
            }
        }
        catch (Exception e) {
            Main.printErrorMessage(sender, e);
        }
        return false;
    }

    public List<String> onTabComplete(final CommandSender arg0, final Command arg1, final String arg2, final String[] args) {
        if (arg1.getName().contains("gamemode") && args.length == 1) {
            final ArrayList<String> list = new ArrayList<String>(Arrays.asList("survival", "creative", "spectator", "adventure", "c", "s", "sp", "a"));
            return list;
        }
        return null;
    }
}
