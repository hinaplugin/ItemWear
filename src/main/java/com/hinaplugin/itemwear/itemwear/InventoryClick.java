package com.hinaplugin.itemwear.itemwear;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick extends CheckWorld implements Listener {

    @EventHandler
    public void onClick(final InventoryClickEvent event){
        final Player player = (Player) event.getWhoClicked();
        if (this.Check(player)){
            return;
        }
        if (!player.hasPermission("itemwear.set")){
            return;
        }
        final Inventory inventory = event.getClickedInventory();
        final int slot = event.getSlot();
        if (inventory == null){
            return;
        }

        if (slot != 39){
            return;
        }

        if (event.getCursor() == null){
            return;
        }

        if (event.getCursor().getType().toString().contains("HELMET")){
            return;
        }

        final ItemStack itemStack = inventory.getItem(slot);

        event.setCancelled(true);
        event.setResult(Event.Result.DENY);
        event.setCurrentItem(event.getCursor());
        player.setItemOnCursor(itemStack);

    }
}
