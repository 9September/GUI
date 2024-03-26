package org.kingdom.yd.gui.menu;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.kingdom.yd.gui.warp.Warp;

public class MenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.YELLOW.toString() + ChatColor.BOLD + "KINGDOM ONLINE") && e.getCurrentItem() != null) {

            Player player = (Player) e.getWhoClicked();
            Warp warp = new Warp();

            switch (e.getRawSlot()) {
                //spawn
                case 0,1,2,9,10,11 -> {
                    warp.teleportToWarp(player, "spawn");
                }
                //core
                case 3,4,5,12,13,14 -> {

                }
                //wild
                case 6,7,8,15,16,17 -> {

                }
                //store
                case 18,19,20,27,28,29 -> {

                }
                //quest
                case 21,22,23,30,31,32 -> {

                }
                //pass
                case 24,25,26,33,34,35 -> {

                }


                //reinforce
                case 36,45 -> {
                    warp.teleportToWarp(player, "reinforce");
                }
                //guild
                case 37,46 -> {
                    warp.teleportToWarp(player, "guild");
                }
                //minigame
                case 38,47 -> {

                }
                //pvp
                case 39,48 -> {
                    warp.teleportToWarp(player, "pvp");
                }
                //library
                case 40,49 -> {
                    warp.teleportToWarp(player, "library");
                }
                //challenge
                case 41,50 -> {

                }
                //skilltree
                case 42,51 -> {

                }
                //tutorial
                case 43,52 -> {
                    warp.teleportToWarp(player, "tutorial");
                }
                //rank
                case 44,53 -> {

                }

            }


            player.closeInventory();
        }
    }

}
