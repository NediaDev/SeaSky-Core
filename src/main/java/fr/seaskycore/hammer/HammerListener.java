package fr.seaskycore.hammer;

import com.bgsoftware.superiorskyblock.island.privilege.IslandPrivileges;
import fr.seaskycore.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.block.*;
import org.bukkit.enchantments.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.block.*;
import com.bgsoftware.superiorskyblock.api.*;
import com.bgsoftware.superiorskyblock.api.wrappers.*;
import com.bgsoftware.superiorskyblock.api.island.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;

public class HammerListener implements Listener
{
    private ArrayList<Material> hammerblock;

    public HammerListener() {
        (this.hammerblock = new ArrayList<Material>()).add(Material.OBSIDIAN);
        this.hammerblock.add(Material.BEDROCK);
        this.hammerblock.add(Material.BARRIER);
        this.hammerblock.add(Material.AIR);
    }

    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        if (e.isCancelled()) {
            return;
        }
        if (this.realItem(e.getPlayer().getItemInHand())) {
            final Player player = e.getPlayer();
            final ItemStack item = player.getItemInHand();
            if (!item.getItemMeta().hasEnchant(Enchantment.LURE) || item.getType() != Material.IRON_PICKAXE) {
                return;
            }
            final Block b = e.getBlock();
            if (this.hammerblock.contains(b.getType())) {
                return;
            }
            final String facing = this.getPlayerFacing(player);
            if (facing.equals("UP") || facing.equals("DOWN")) {
                this.updateDurability(item, player);
                for (final Block bp : this.getHammerBlock(b, "UP")) {
                    this.possibleBreak(bp, item, player);
                }
                return;
            }
            if (facing.equals("NORTH") || facing.equals("SOUTH")) {
                this.updateDurability(item, player);
                for (final Block bp : this.getHammerBlock(b, "NORTH")) {
                    this.possibleBreak(bp, item, player);
                }
                return;
            }
            if (facing.equals("EAST") || facing.equals("WEST")) {
                this.updateDurability(item, player);
                for (final Block bp : this.getHammerBlock(b, "EAST")) {
                    this.possibleBreak(bp, item, player);
                }

            }
        }
    }

    public List<Block> getHammerBlock(final Block block, final String type) {
        final List<Block> lblock = new ArrayList<Block>();
        if (type.equals("UP") || type.equals("DOWN")) {
            lblock.add(block.getRelative(BlockFace.NORTH));
            lblock.add(block.getRelative(BlockFace.SOUTH));
            lblock.add(block.getRelative(BlockFace.EAST));
            lblock.add(block.getRelative(BlockFace.WEST));
            lblock.add(block.getRelative(BlockFace.NORTH_EAST));
            lblock.add(block.getRelative(BlockFace.NORTH_WEST));
            lblock.add(block.getRelative(BlockFace.SOUTH_EAST));
            lblock.add(block.getRelative(BlockFace.SOUTH_WEST));
            return lblock;
        }
        if (type.equals("SOUTH") || type.equals("NORTH")) {
            lblock.add(block.getRelative(BlockFace.EAST));
            lblock.add(block.getRelative(BlockFace.WEST));
            lblock.add(block.getRelative(BlockFace.UP));
            lblock.add(block.getRelative(BlockFace.DOWN));
            lblock.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST));
            lblock.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST));
            lblock.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST));
            lblock.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST));
            return lblock;
        }
        if (type.equals("EAST") || type.equals("WEST")) {
            lblock.add(block.getRelative(BlockFace.NORTH));
            lblock.add(block.getRelative(BlockFace.SOUTH));
            lblock.add(block.getRelative(BlockFace.UP));
            lblock.add(block.getRelative(BlockFace.DOWN));
            lblock.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH));
            lblock.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH));
            lblock.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.NORTH));
            lblock.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.SOUTH));
            return lblock;
        }
        return lblock;
    }

    public void possibleBreak(final Block block, final ItemStack item, final Player player) {
        if ((Main.getInstance().canBuild(player, block) || player.isOp() || player.hasPermission("astralitems.override"))) {
            boolean isASuperiorPlayer;
            try {
                final SuperiorPlayer p = SuperiorSkyblockAPI.getPlayer(player);
                isASuperiorPlayer = true;
            }
            catch (Exception e) {
                isASuperiorPlayer = false;
            }
            boolean skyblockPermssion;
            if (isASuperiorPlayer) {
                try {
                    final SuperiorPlayer p = SuperiorSkyblockAPI.getPlayer(player);
                    final Island island = SuperiorSkyblockAPI.getIslandAt(block.getLocation());
                    skyblockPermssion = island.getPlayerPermissions().get(p).hasPermission(IslandPrivileges.BREAK);
                }
                catch (NullPointerException e2) {
                    skyblockPermssion = true;
                }
            }
            else {
                skyblockPermssion = true;
            }
            if ((skyblockPermssion || player.isOp() || player.hasPermission("astralitems.override")) && !this.hammerblock.contains(block.getType())) {
                block.breakNaturally(item);
                if (block.getType().equals((Object)Material.NETHER_WART)) {
                    final int random = (int)(Math.random() * 3.0);
                    block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.NETHER_WART, random + 2));
                }
                this.updateDurability(item, player);
            }
        }
    }

    public void updateDurability(final ItemStack item, final Player p) {
        final ItemStack hammer = item;
        final ItemMeta meta = hammer.getItemMeta();

    }

    public void sendPacket(final Player p, final String text) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(text));
    }

    public Boolean realItem(final ItemStack itemstack) {
        if (itemstack == null) {
            return false;
        }
        if (!itemstack.hasItemMeta()) {
            return false;
        }
        if (!itemstack.getItemMeta().hasDisplayName()) {
            return false;
        }
        return true;
    }

    public String getPlayerFacing(final Player player) {
        final Float pitch = player.getLocation().getPitch();
        Float y = player.getLocation().getYaw();
        if (pitch >= 50.0f) {
            return "DOWN";
        }
        if (pitch <= -50.0f) {
            return "UP";
        }
        String dir = null;
        if (y < 0.0f) {
            y += 360.0f;
        }
        y %= 360.0f;
        final int i = (int)((y + 8.0f) / 22.5);
        if (i == 0) {
            dir = "SOUTH";
        }
        else if (i == 2) {
            dir = "WEST";
        }
        else if (i == 3) {
            dir = "WEST";
        }
        else if (i == 4) {
            dir = "WEST";
        }
        else if (i == 5) {
            dir = "WEST";
        }
        else if (i == 6) {
            dir = "NORTH";
        }
        else if (i == 7) {
            dir = "NORTH";
        }
        else if (i == 8) {
            dir = "NORTH";
        }
        else if (i == 9) {
            dir = "NORTH";
        }
        else if (i == 10) {
            dir = "EAST";
        }
        else if (i == 11) {
            dir = "EAST";
        }
        else if (i == 12) {
            dir = "EAST";
        }
        else if (i == 13) {
            dir = "EAST";
        }
        else if (i == 1) {
            dir = "SOUTH";
        }
        else if (i == 14) {
            dir = "SOUTH";
        }
        else if (i == 15) {
            dir = "SOUTH";
        }
        else {
            dir = "SOUTH";
        }
        return dir;
    }
}
