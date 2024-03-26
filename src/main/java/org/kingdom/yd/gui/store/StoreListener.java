package org.kingdom.yd.gui.store;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.kingdom.yd.gui.warp.Warp;

public class StoreListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.GREEN.toString() + ChatColor.BOLD + "STORE") && e.getCurrentItem() != null) {

            Player player = (Player) e.getWhoClicked();
            Warp warp = new Warp();

            switch (e.getRawSlot()) {
                //market
                case 0,1,2,9,10,11 -> {
                    warp.teleportToWarp(player, "market");
                }
                //usermarket
                case 3,4,5,12,13,14 -> {
                    warp.teleportToWarp(player, "usermarket");
                }
                //auction
                case 6,7,8,15,16,17 -> {
                    warp.teleportToWarp(player, "auction");
                }

            }


            player.closeInventory();
        }
    }

}
