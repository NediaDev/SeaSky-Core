package fr.seaskycore.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        if (block.getType() == Material.BUDDING_AMETHYST) {
            if (event.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.SILK_TOUCH) > 0) {
                event.setCancelled(true);
                block.getWorld().dropItemNaturally(block.getLocation(), new org.bukkit.inventory.ItemStack(Material.BUDDING_AMETHYST));
                block.setType(Material.AIR);
            }
        }
    }
}
