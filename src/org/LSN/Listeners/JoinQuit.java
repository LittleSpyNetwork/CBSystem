package org.LSN.Listeners;

import org.LSN.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinQuit implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().setItem(8, Utils.createItem(Material.NETHER_STAR, 1, 0, "§6§lCityBuild Menü"));
	}

}
