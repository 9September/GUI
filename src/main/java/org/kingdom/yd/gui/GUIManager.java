package org.kingdom.yd.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;

public class GUIManager implements CommandExecutor, Listener {
    private JavaPlugin plugin;
    private static final String MENU_TITLE = ChatColor.YELLOW.toString() + ChatColor.BOLD + "KINGDOM ONLINE";
    private static final String STORE_TITLE = ChatColor.GREEN.toString() + ChatColor.BOLD + "STORE";

    public GUIManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            openMenu(player);
        }
        return true;
    }

    private void openMenu(Player player) {
        Inventory menu = Bukkit.createInventory(null, 54, MENU_TITLE);
        setupMenuItems(menu);
        player.openInventory(menu);
    }
    private void openStore(Player player) {
        Inventory store = Bukkit.createInventory(null, 27, STORE_TITLE);
        setupStoreItems(store);
        player.openInventory(store);
    }

    private void setupMenuItems(Inventory inv) {
        // 스폰
        setupItem(inv, new int[]{0, 1, 2, 9, 10, 11}, Material.RED_STAINED_GLASS_PANE, ChatColor.RED + "스폰으로 이동하기", ChatColor.GRAY + "좌클릭 시 스폰으로 이동합니다.");
        // 코어
        setupItem(inv, new int[]{3, 4, 5, 12, 13, 14}, Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GOLD + "내 코어 보기", ChatColor.GRAY + "좌클릭 시 내 코어를 확인합니다.");
        // 야생
        setupItem(inv, new int[]{6, 7, 8, 15, 16, 17}, Material.YELLOW_STAINED_GLASS_PANE, ChatColor.YELLOW + "필드로 이동하기", ChatColor.GRAY + "좌클릭 시 필드를 선택할 수 있습니다.", ChatColor.GRAY + "야생필드와 몬스터필드가 존재합니다.");
        // 상점
        setupItem(inv, new int[]{18, 19, 20, 27, 28, 29}, Material.LIME_STAINED_GLASS_PANE, ChatColor.GREEN + "상점으로 이동하기", ChatColor.GRAY + "좌클릭 시 상점을 확인합니다.");
        // 퀘스트
        setupItem(inv, new int[]{21, 22, 23, 30, 31, 32}, Material.BLUE_STAINED_GLASS_PANE, ChatColor.BLUE + "퀘스트 확인하기", ChatColor.GRAY + "좌클릭 시 내 퀘스트 정보를 확인할 수 있습니다.");
        // 패스
        setupItem(inv, new int[]{24, 25, 26, 33, 34, 35}, Material.PURPLE_STAINED_GLASS_PANE, ChatColor.DARK_PURPLE + "패스 오픈하기", ChatColor.GRAY + "좌클릭 시 패스를 확인할 수 있습니다.", ChatColor.GRAY + "패스로는 출석패스, 레벨패스, 퀘스트패스, 접속시간패스, 누적시간패스가 있습니다.");
        // 강화
        setupItem(inv, new int[]{36, 45}, Material.GLASS_PANE, ChatColor.WHITE + "강화", ChatColor.GRAY + "좌클릭 시 강화소로 이동합니다.");
        // 길드
        setupItem(inv, new int[]{37, 46}, Material.GRAY_STAINED_GLASS_PANE, ChatColor.WHITE + "길드", ChatColor.GRAY + "좌클릭 시 모험가 길드로 이동합니다.");
        // 미니게임
        setupItem(inv, new int[]{38, 47}, Material.LIGHT_BLUE_STAINED_GLASS_PANE, ChatColor.WHITE + "미니게임", ChatColor.GRAY + "좌클릭 시 미니게임을 오픈합니다.");
        // PVP
        setupItem(inv, new int[]{39, 48}, Material.WHITE_STAINED_GLASS_PANE, ChatColor.WHITE + "PVP", ChatColor.GRAY + "좌클릭 시 콜로세움으로 이동합니다.");
        // 도서관
        setupItem(inv, new int[]{40, 49}, Material.MAGENTA_STAINED_GLASS_PANE, ChatColor.WHITE + "도서관", ChatColor.GRAY + "좌클릭 시 도서관으로 이동합니다.");
        // 도전과제
        setupItem(inv, new int[]{41, 50}, Material.BROWN_STAINED_GLASS_PANE, ChatColor.WHITE + "도전과제", ChatColor.GRAY + "좌클릭 시 도전과제를 확인합니다.");
        // 스킬트리
        setupItem(inv, new int[]{42, 51}, Material.GREEN_STAINED_GLASS_PANE, ChatColor.WHITE + "스킬트리", ChatColor.GRAY + "좌클릭 시 스킬트리를 확인합니다.");
        // 튜토리얼
        setupItem(inv, new int[]{43, 52}, Material.CYAN_STAINED_GLASS_PANE, ChatColor.WHITE + "튜토리얼", ChatColor.GRAY + "좌클릭 시 튜토리얼로 이동합니다.");
        // 랭크
        setupItem(inv, new int[]{44, 53}, Material.BLACK_STAINED_GLASS_PANE, ChatColor.WHITE + "랭킹", ChatColor.GRAY + "좌클릭 시 랭킹을 확인합니다.");
    }

    private void setupStoreItems(Inventory inv) {
        //시장가
        setupItem(inv, new int[]{0, 1, 2, 9, 10, 11, 18, 19, 20}, Material.RED_STAINED_GLASS_PANE, ChatColor.GREEN + "시장가로 이동하기", ChatColor.GRAY + "좌클릭 시 시장가로 이동합니다.");
        //유저마켓
        setupItem(inv, new int[]{3, 4, 5, 12, 13, 14, 21, 22, 23}, Material.YELLOW_STAINED_GLASS_PANE, ChatColor.GOLD + "유저마켓 오픈하기", ChatColor.GRAY + "좌클릭 시 유저마켓을 오픈합니다.");
        //경매소
        setupItem(inv, new int[]{6, 7, 8, 15, 16, 17, 24, 25, 26}, Material.GREEN_STAINED_GLASS_PANE, ChatColor.BLUE + "경매소로 이동하기", ChatColor.GRAY + "좌클릭 시 경매소로 이동합니다.");
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getClickedInventory();
        int slot = event.getSlot();

        if (inv == null) return;

        //MENU
        if (event.getView().getTitle().equals(MENU_TITLE)) {
            event.setCancelled(true);
            handleMenuGUI(player, slot);
        }
        //STORE
        if (event.getView().getTitle().equals(STORE_TITLE)) {
            event.setCancelled(true);
            handleStoreGUI(player, slot);
        }
    }

    private void handleMenuGUI(Player player, int slot) {
        Warp warp = new Warp();

        switch (slot) {
            //spawn
            case 0,1,2,9,10,11:
                warp.teleportToWarp(player, "spawn");
                break;

            //core
            case 3,4,5,12,13,14:
                player.performCommand("core");
                break;

            //wild
            case 6,7,8,15,16,17:

                break;
            //store
            case 18,19,20,27,28,29:
                openStore(player);
                break;
            //quest
            case 21,22,23,30,31,32:

                break;
            //pass
            case 24,25,26,33,34,35:

                break;
            //reinforce
            case 36,45:
                warp.teleportToWarp(player, "reinforce");
                break;
            //guild
            case 37,46:
                warp.teleportToWarp(player, "guild");
                break;
            //minigame
            case 38,47:
                warp.teleportToWarp(player, "minigame");
                break;
            //pvp
            case 39,48:
                warp.teleportToWarp(player, "pvp");
                break;
            //library
            case 40,49:
                warp.teleportToWarp(player, "library");
                break;
            //challenge
            case 41,50:

                break;
            //skilltree
            case 42,51:

                break;
            //tutorial
            case 43,52:
                warp.teleportToWarp(player, "tutorial");
                break;
            //rank
            case 44,53:

                break;
        }
    }

    private void handleStoreGUI(Player player, int slot) {
        Warp warp = new Warp();

        switch (slot) {
            //market
            case 0,1,2,9,10,11 -> {
                warp.teleportToWarp(player, "market");
            }
            //usermarket
            case 3,4,5,12,13,14 -> {
                //usermarket GUI
            }
            //auction
            case 6,7,8,15,16,17 -> {
                warp.teleportToWarp(player, "auction");
            }
        }
    }

    private ItemStack createItem(Material material, String name, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(Collections.singletonList(lore));
            item.setItemMeta(meta);
        }
        return item;
    }

    private void setupItem(Inventory inv, int[] slots, Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(Arrays.asList(lore));
            item.setItemMeta(meta);
        }
        for (int slot : slots) {
            inv.setItem(slot, item);
        }
    }
}
