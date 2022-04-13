package me.PhilosophyWithJosh.popupMobs.listeners;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.PhilosophyWithJosh.popupMobs.Main;

public class blockListener implements Listener
{
	@SuppressWarnings("unused")
	private Main plugin;
	private ArrayList<Material> blocklist = new ArrayList<Material>();
	private ArrayList<EntityType> entitylist = new ArrayList<EntityType>();

	
	public blockListener(Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
		
		// lists of blocks to checkif the player is standing on it or not
		blocklist.add(Material.OBSIDIAN);
		blocklist.add(Material.CACTUS);
		blocklist.add(Material.SAND);
		blocklist.add(Material.OAK_LOG);
		blocklist.add(Material.DIAMOND_ORE);

		// LIST OF CORRESPONDING MOBS TO SPAWN
		entitylist.add(EntityType.COW);
		entitylist.add(EntityType.BEE);
		entitylist.add(EntityType.WOLF);
		entitylist.add(EntityType.ZOMBIE);
		entitylist.add(EntityType.DOLPHIN);

		
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent pme)
	{	
		Player mb = pme.getPlayer();
		Location loc = mb.getLocation().clone().subtract(0, 1, 0);
		Block square = loc.getBlock();
		Material mat = square.getType();
		
		for (int i = 0; i<blocklist.size(); i++) {
			if (blocklist.get(i)== mat) {
				mb.getWorld().spawnEntity(loc, entitylist.get(i));
				mb.sendMessage("Spawning entity");
				
			}
		}
	}
}
