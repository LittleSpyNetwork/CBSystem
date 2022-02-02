package org.LSN.Inventories;

import org.LSN.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MenuGUI implements Listener {
	
	  @EventHandler
	  public void interact(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
	      p.getItemInHand().getType().equals(Material.NETHER_STAR) && 
	      p.getItemInHand().getItemMeta().getDisplayName().contains("§6§lCityBuild Menü")) {
	      Inventory Inv = Bukkit.createInventory((InventoryHolder)p, 45, "§6§lCityBuild Menü");
	      for (int i = 0; i < Inv.getSize(); i++)
	        Inv.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " ")); 
	      p.setItemOnCursor(null);
	      Inv.setItem(22, Utils.createItem(Material.COMPASS, 1, 0, "§aWarp Menu"));
	      Inv.setItem(40, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
	      p.openInventory(Inv);
	    } 
	  }
	  
	  @EventHandler
	  public void warpClick(InventoryClickEvent e) {
	    HumanEntity p = e.getWhoClicked();
	    if (e.getInventory().getTitle().contains("§6§lCityBuild Menü\"")) {
	      if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§aWarp Menu")) {
	        Inventory WarpMenu = Bukkit.createInventory((InventoryHolder)p, 54, "§a§lWarp Menu");
	        for (int i = 0; i < WarpMenu.getSize(); i++)
	          WarpMenu.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " ")); 
	        WarpMenu.setItem(21, Utils.createItem(Material.REDSTONE, 1, 0, "§4Team"));
	        WarpMenu.setItem(22, Utils.createItem(Material.GOLDEN_APPLE, 1, 0, "§6Spawn"));
	        WarpMenu.setItem(23, Utils.createItem(Material.GRASS, 1, 0, "§2Farmwelt"));
	        WarpMenu.setItem(49, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
	        p.openInventory(WarpMenu);
	      } 
	      if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§cInventar schließen"))
	        p.closeInventory(); 
	      e.setCancelled(true);
	    } 
	  }
	  
	  @EventHandler
	  public void warpMenu(InventoryClickEvent e) {
	    HumanEntity p = e.getWhoClicked();
	    if (e.getInventory().getTitle().contains("Men")) {
	      if (e.getSlot() == 22) {
	        Location Spawn = new Location(Bukkit.getWorld("plotworld"), 122.5D, 65.0D, 74.5D);
	        p.teleport(Spawn);
	        p.closeInventory();
	      } 
	      if (e.getSlot() == 23) {
	        Location Spawn = new Location(Bukkit.getWorld("Farmwelt"), 0.5D, 65.0D, 0.5D);
	        p.teleport(Spawn);
	        p.closeInventory();
	      } 
	      if (e.getSlot() == 21) {
	        Location loc = new Location(Bukkit.getWorld("plotworld"), 105.5D, 60.0D, 127.5D);
	        loc.setYaw(90.0F);
	        p.teleport(loc);
	        p.closeInventory();
	      } 
	      if (e.getSlot() == 49)
	        p.closeInventory(); 
	      e.setCancelled(true);
	    } 
	  }
	  
	  @EventHandler
	  public void moveItem(InventoryClickEvent e) {
	    if (e.getSlot() == 8)
	      e.setCancelled(true); 
	  }
	  
	  @EventHandler
	  public void onClickSlot(PlayerDropItemEvent e) {
	    Player p = e.getPlayer();
	    if (p.getInventory().getHeldItemSlot() == 8)
	      e.setCancelled(true); 
	  }

}
