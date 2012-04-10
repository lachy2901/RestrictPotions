package com.precipicegames.lachy2901.restrictpotions;

import org.bukkit.plugin.java.JavaPlugin;

public class RestrictPotions extends JavaPlugin{

	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new RestrictPotionsListener(this), this);
	}
	
	public void onDisable() {
		
	}
	
}
