package org.LSN.Utils;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils implements Listener {

	public static ItemStack createItem(Material mat, int anzahl, int shortid, String Name) {
		short s = (short) shortid;
		ItemStack i = new ItemStack(mat, anzahl, s);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Name);
		i.setItemMeta(meta);
		return i;
	}

	@EventHandler
	public void onMove(InventoryMoveItemEvent e) {
		if (e.getSource().getType().toString().equals("")) {
			e.setCancelled(true);
		} else {
			e.setCancelled(false);
		}
	}

}
