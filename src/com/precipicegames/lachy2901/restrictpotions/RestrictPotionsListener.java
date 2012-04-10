package com.precipicegames.lachy2901.restrictpotions;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RestrictPotionsListener implements Listener{
	
	RestrictPotions plugin;
	
	public boolean contains(short[] array, short n) {
		for (int i : array) {
			if (i == n) {
				return true;
			}
		}
		return false;
	}
	
	public RestrictPotionsListener(RestrictPotions instance) {
		plugin = instance;
	}
	
	short[] safe = {8193, 8257, 8225, 8194, 8258, 8226, 8195, 8259, 8227, 8197, 8261, 8229, 8201, 8265, 8223};
	short[] harm = {8196, 8260, 8228, 8200, 8264, 8232, 8202, 8266, 8234, 8204, 8268, 8236};
	short[] ssafe = {16385, 16449, 16417, 16386, 16450, 16418, 16387, 16451, 16419, 16389, 16453, 16421, 16393, 16457, 16425};
	short[] sharm = {16388, 16452, 16420, 16392, 16456, 16424, 16394, 16458, 16426, 16396, 16460, 16428};
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.hasItem()) {
			ItemStack item = event.getItem();
			if (item.getTypeId() == 373) {
				if (contains(safe, item.getDurability())) {
					if (!event.getPlayer().hasPermission("potion.safe")) {
						event.setCancelled(true);
						event.getPlayer().sendMessage(ChatColor.RED + "You don't have permission to do that!");
					}
				} else if (contains(harm, item.getDurability())) {
					if (!event.getPlayer().hasPermission("potion.harm")) {
						event.setCancelled(true);
						event.getPlayer().sendMessage(ChatColor.RED + "You don't have permission to do that!");
					}
				} else if (contains(ssafe, item.getDurability())) {
					if (!event.getPlayer().hasPermission("potion.ssafe")) {
						event.setCancelled(true);
						event.getPlayer().sendMessage(ChatColor.RED + "You don't have permission to do that!");
					}
				} else if (contains(sharm, item.getDurability())) {
					if (!event.getPlayer().hasPermission("potion.sharm")) {
						event.setCancelled(true);
						event.getPlayer().sendMessage(ChatColor.RED + "You don't have permission to do that!");
					}
				}
				
			} else if (item.getTypeId() == 384) {
				if (!event.getPlayer().hasPermission("potion.exp")) {
					event.setCancelled(true);
					event.getPlayer().sendMessage(ChatColor.RED + "You don't have permission to do that!");
				}
			}
		}
	}
	
}
