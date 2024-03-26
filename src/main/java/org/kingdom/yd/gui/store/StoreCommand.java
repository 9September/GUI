package org.kingdom.yd.gui.store;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class StoreCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            Inventory inv = Bukkit.createInventory(player, 27, ChatColor.GREEN.toString() + ChatColor.BOLD + "STORE");

            //market
            ItemStack market = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            ItemMeta marketMeta = market.getItemMeta();
            marketMeta.setDisplayName(ChatColor.GREEN + "시장가로 이동하기");
            marketMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 시장가로 이동합니다."));
            market.setItemMeta(marketMeta);

            for (int i : new int[] {0,1,2,9,10,11}) {
                inv.setItem(i,market);
            }

            //UserMarket
            ItemStack userMarket = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            ItemMeta userMarketMeta = userMarket.getItemMeta();
            userMarketMeta.setDisplayName(ChatColor.GOLD + "유저마켓 오픈하기");
            userMarketMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 유저마켓을 오픈합니다."));
            userMarket.setItemMeta(userMarketMeta);

            for (int i : new int[] {3,4,5,12,13,14}) {
                inv.setItem(i,userMarket);
            }

            //Auction
            ItemStack auction = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            ItemMeta auctionMeta = auction.getItemMeta();
            auctionMeta.setDisplayName(ChatColor.YELLOW + "경매소로 이동하기");
            auctionMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 경매소로 이동합니다."));
            auction.setItemMeta(auctionMeta);

            for (int i : new int[] {6,7,8,15,16,17}) {
                inv.setItem(i,auction);
            }



            player.openInventory(inv);
        }


        return false;
    }
}
