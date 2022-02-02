package org.LSN.Main;

import org.LSN.Inventories.MenuGUI;
import org.LSN.Listeners.JoinQuit;
import org.LSN.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		init();
	}
	
	private void init() {
	    Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
	    Bukkit.getPluginManager().registerEvents(new MenuGUI(), this);
	    Bukkit.getPluginManager().registerEvents(new Utils(), this);
	}

}
