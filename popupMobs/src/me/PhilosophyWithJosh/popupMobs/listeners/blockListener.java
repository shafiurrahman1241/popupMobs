package me.PhilosophyWithJosh.popupMobs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.PhilosophyWithJosh.popupMobs.Main;

public class blockListener implements Listener
{
	@SuppressWarnings("unused")
	private Main plugin;
	
	public blockListener(Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	public void onMove(PlayerMoveEvent pme)
	{	
		
	}
}
