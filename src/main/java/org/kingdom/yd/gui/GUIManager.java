package org.kingdom.yd.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.kingdom.yd.gui.pass.Attendance;
import org.kingdom.yd.gui.pass.Level;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class GUIManager implements CommandExecutor, Listener {

    private GUI plugin;
    private Attendance attendance;
    private Level level;

    private static final String MENU_TITLE = ChatColor.YELLOW.toString() + ChatColor.BOLD + "KINGDOM ONLINE";
    private static final String STORE_TITLE = ChatColor.GREEN.toString() + ChatColor.BOLD + "상점 GUI";
    private static final String FIELD_TITLE = ChatColor.BLUE.toString() + ChatColor.BOLD + "필드 GUI";
    private static final String PASS_TITLE = ChatColor.RED.toString() + ChatColor.BOLD + "패스 GUI";

    private static final String PASSLEVEL_TITLE = ChatColor.GOLD.toString() + ChatColor.BOLD + "레벨 패스";
    private static final String PASSQUEST_TITLE = ChatColor.GOLD.toString() + ChatColor.BOLD + "퀘스트 패스";
    private static final String PASSCONNECTION_TITLE = ChatColor.GOLD.toString() + ChatColor.BOLD + "접속 시간 패스";
    private static final String PASSCUMULATE_TITLE = ChatColor.GOLD.toString() + ChatColor.BOLD + "누적 시간 패스";

    public GUIManager(GUI plugin) {

        this.plugin = plugin;
        this.attendance = new Attendance(plugin);
        this.level = new Level(plugin);
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

    private void openField(Player player) {
        Inventory field = Bukkit.createInventory(null, 36, FIELD_TITLE);
        setupFieldItems(field);
        player.openInventory(field);
    }

    private void openPass(Player player) {
        Inventory pass = Bukkit.createInventory(null, 45, PASS_TITLE);
        setupPassItems(pass);
        player.openInventory(pass);

    }

    private void openPassLevel(Player player) {
        Inventory pass = Bukkit.createInventory(null, 45, PASSLEVEL_TITLE);
        setupPassLevelItems(pass);
        player.openInventory(pass);

    }

    private void openPassQuest(Player player) {
        Inventory pass = Bukkit.createInventory(null, 54, PASSQUEST_TITLE);
        setupPassQuestItems(pass);
        player.openInventory(pass);

    }
    private void openPassConnection(Player player) {
        Inventory pass = Bukkit.createInventory(null, 54, PASSCONNECTION_TITLE);
        setupPassConnectionItems(pass);
        player.openInventory(pass);

    }
    private void openPassCumulate(Player player) {
        Inventory pass = Bukkit.createInventory(null, 54, PASSCUMULATE_TITLE);
        setupPassCumulateItems(pass);
        player.openInventory(pass);

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

    private void setupFieldItems(Inventory inv) {
        //몬스터
        setupItem(inv, new int[]{0, 1, 2, 3, 9, 10, 11, 12}, Material.RED_STAINED_GLASS_PANE, ChatColor.GREEN + "몬스터 필드로 이동하기", ChatColor.GRAY + "좌클릭 시 몬스터 필드로 이동합니다.");
        //야생
        setupItem(inv, new int[]{18, 19, 20, 21, 27, 28, 29, 30}, Material.BLUE_STAINED_GLASS_PANE, ChatColor.GREEN + "야생 필드로 이동하기", ChatColor.GRAY + "좌클릭 시 야생 필드로 이동합니다.");

    }

    private void setupPassItems(Inventory inv) {
        //출석
        setupItem(inv, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, Material.RED_WOOL, ChatColor.RED + "출석 패스", ChatColor.GRAY + "좌클릭 시 출석 패스를 오픈합니다.");
        //레벨
        setupItem(inv, new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17}, Material.ORANGE_WOOL, ChatColor.GOLD + "레벨 패스", ChatColor.GRAY + "좌클릭 시 레벨 패스를 오픈합니다.");
        //퀘스트
        setupItem(inv, new int[]{18, 19, 20, 21, 22, 23, 24, 25, 26}, Material.YELLOW_WOOL, ChatColor.YELLOW + "퀘스트 패스", ChatColor.GRAY + "좌클릭 시 퀘스트 패스를 오픈합니다.");
        //접속 시간
        setupItem(inv, new int[]{27, 28, 29, 30, 31, 32, 33, 34, 35}, Material.GREEN_WOOL, ChatColor.GREEN + "접속 시간 패스", ChatColor.GRAY + "좌클릭 시 접속 시간 패스를 오픈합니다.");
        //누적 시간
        setupItem(inv, new int[]{36, 37, 38, 39, 40, 41, 42, 43, 44}, Material.BLUE_WOOL, ChatColor.BLUE + "누적 시간 패스", ChatColor.GRAY + "좌클릭 시 누적 시간 패스를 오픈합니다.");
    }

    private void setupPassLevelItems(Inventory inv) {

        setupItem(inv, new int[] {11}, Material.DIAMOND,ChatColor.GREEN+"5레벨 달성 보상", ChatColor.AQUA+"로어 추가");
        setupItem(inv, new int[] {13}, Material.DIAMOND,ChatColor.GREEN+"10레벨 달성 보상", ChatColor.AQUA+"로어 추가");
        setupItem(inv, new int[] {15}, Material.DIAMOND,ChatColor.GREEN+"15레벨 달성 보상", ChatColor.AQUA+"로어 추가");
        setupItem(inv, new int[] {19}, Material.DIAMOND,ChatColor.GREEN+"20레벨 달성 보상", ChatColor.AQUA+"로어 추가");
        setupItem(inv, new int[] {21}, Material.DIAMOND,ChatColor.GREEN+"25레벨 달성 보상", ChatColor.AQUA+"로어 추가");
        setupItem(inv, new int[] {23}, Material.DIAMOND,ChatColor.GREEN+"30레벨 달성 보상", ChatColor.AQUA+"로어 추가");
        setupItem(inv, new int[] {25}, Material.DIAMOND,ChatColor.GREEN+"35레벨 달성 보상", ChatColor.AQUA+"로어 추가");
        setupItem(inv, new int[] {29}, Material.DIAMOND,ChatColor.GREEN+"40레벨 달성 보상", ChatColor.AQUA+"로어 추가");
        setupItem(inv, new int[] {31}, Material.DIAMOND,ChatColor.GREEN+"45레벨 달성 보상", ChatColor.AQUA+"로어 추가");
        setupItem(inv, new int[] {33}, Material.DIAMOND,ChatColor.GREEN+"50레벨 달성 보상", ChatColor.AQUA+"로어 추가");
    }

    private void setupPassQuestItems(Inventory inv) {
        setupItem(inv, new int[]{0, 1}, Material.RED_STAINED_GLASS_PANE, ChatColor.GREEN + "몬스터 필드로 이동하기", ChatColor.GRAY + "좌클릭 시 몬스터 필드로 이동합니다.");
        setupItem(inv, new int[]{18, 19}, Material.BLUE_STAINED_GLASS_PANE, ChatColor.GREEN + "야생 필드로 이동하기", ChatColor.GRAY + "좌클릭 시 야생 필드로 이동합니다.");
    }

    private void setupPassConnectionItems(Inventory inv) {
        setupItem(inv, new int[]{0, 1}, Material.RED_STAINED_GLASS_PANE, ChatColor.GREEN + "몬스터 필드로 이동하기", ChatColor.GRAY + "좌클릭 시 몬스터 필드로 이동합니다.");
        setupItem(inv, new int[]{18, 19}, Material.BLUE_STAINED_GLASS_PANE, ChatColor.GREEN + "야생 필드로 이동하기", ChatColor.GRAY + "좌클릭 시 야생 필드로 이동합니다.");
    }

    private void setupPassCumulateItems(Inventory inv) {
        setupItem(inv, new int[]{0, 1}, Material.RED_STAINED_GLASS_PANE, ChatColor.GREEN + "몬스터 필드로 이동하기", ChatColor.GRAY + "좌클릭 시 몬스터 필드로 이동합니다.");
        setupItem(inv, new int[]{18, 19}, Material.BLUE_STAINED_GLASS_PANE, ChatColor.GREEN + "야생 필드로 이동하기", ChatColor.GRAY + "좌클릭 시 야생 필드로 이동합니다.");
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getClickedInventory();
        int slot = event.getSlot();
        String title = event.getView().getTitle();
        if (inv == null) return;



        if (event.getView().getTitle().equals(MENU_TITLE)) {
            event.setCancelled(true);
            //Menu
            handleMenuGUI(player, slot);
        } else if (event.getView().getTitle().equals(STORE_TITLE)) {
            event.setCancelled(true);
            //Store
            handleStoreGUI(player, slot);
        } else if (event.getView().getTitle().equals(FIELD_TITLE)) {
            event.setCancelled(true);
            //Field
            handleFieldGUI(player, slot);
        } else if (event.getView().getTitle().equals(PASS_TITLE)) {
            event.setCancelled(true);
            //Pass
            handlePassGUI(player, slot);



        } else if (event.getView().getTitle().equals(PASSLEVEL_TITLE)) {
            event.setCancelled(true);
            //Pass Level
            handlePassLevel(player, slot);
        } else if (event.getView().getTitle().equals(PASSQUEST_TITLE)) {
            event.setCancelled(true);
            //Pass Quest
            handlePassQuest(player, slot);
        } else if (event.getView().getTitle().equals(PASSCONNECTION_TITLE)) {
            event.setCancelled(true);
            //Pass Connection
            handlePassConnection(player, slot);
        } else if (event.getView().getTitle().equals(PASSCUMULATE_TITLE)) {
            event.setCancelled(true);
            //Pass Cumulate
            handlePassCumulate(player, slot);
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
                boolean wasOp = player.isOp();
                try {
                    player.setOp(true);  // 플레이어에게 OP 권한 부여
                    player.performCommand("core");
                } finally {
                    player.setOp(wasOp);  // 플레이어의 OP 상태를 원래대로 복구
                }

                break;
            //wild
            case 6,7,8,15,16,17:
                openField(player);
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
                openPass(player);
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
                boolean wasOp = player.isOp();
                try {
                    player.setOp(true);  // 플레이어에게 OP 권한 부여
                    player.performCommand("유저거래소 열기");
                } finally {
                    player.setOp(wasOp);  // 플레이어의 OP 상태를 원래대로 복구
                }
            }
            //auction
            case 6,7,8,15,16,17 -> {
                warp.teleportToWarp(player, "auction");
            }
        }
    }

    private void handleFieldGUI(Player player, int slot) {
        Warp warp = new Warp();

        switch (slot) {
            case 0,1,2,3,9,10,11,12 -> {
                warp.teleportToWarp(player, "monster_field");
            }
            case 18,19,20,21,27,28,29,30 -> {
                warp.teleportToWarp(player, "wild_field");
            }
        }
    }

    private void handlePassGUI(Player player, int slot) {
        switch (slot) {
            case 0,1,2,3,4,5,6,7,8 -> {
                attendance.checkAttendancePass(player);
            }
            case 9,10,11,12,13,14,15,16,17 -> {
                //Level패스를 구입했는지
                if (level.checkLevelPass(player)) {
                    openPassLevel(player);
                }
            }
            case 18,19,20,21,22,23,24,25,26 -> {
                openPassQuest(player);
            }
            case 27,28,29,30,31,32,33,34,35 -> {
                openPassConnection(player);
            }
            case 36,37,38,39,40,41,42,43,44 -> {
                openPassCumulate(player);
            }
        }
    }

    private void handlePassLevel(Player player, int slot) {
        // Retrieve the required level for the clicked slot
        int requiredLevel = level.getRequiredLevel(slot);

        // Check if the player's level is sufficient and they haven't received the reward yet
        if (player.getLevel() >= requiredLevel && !level.hasReceivedReward(player, requiredLevel)) {
            // Determine the reward based on the slot clicked
            switch (slot) {
                case 11: // For level 5 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                case 13: // For level 10 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                case 15: // For level 15 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                case 19: // For level 20 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                case 21: // For level 25 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                case 23: // For level 30 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                case 25: // For level 35 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                case 29: // For level 40 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                case 31: // For level 45 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                case 33: // For level 50 reward
                    player.performCommand("give " + player.getName() + " minecraft:diamond 1");
                    player.sendMessage(ChatColor.GOLD+"레벨 " + requiredLevel + ChatColor.GREEN + " 보상을 수령했습니다! ");
                    level.markRewardAsReceived(player, requiredLevel); // Mark the reward as received
                    break;
                default:
                    break;
            }
        } else if (player.getLevel() < requiredLevel) {
            player.sendMessage(ChatColor.RED + "보상을 수령할 수 없습니다. 요구 레벨: " + requiredLevel);
        } else {
            player.sendMessage(ChatColor.RED + "이미 보상을 받았습니다.");
        }
    }

    private void handlePassQuest(Player player, int slot) {

    }

    private void handlePassConnection(Player player, int slot) {

    }

    private void handlePassCumulate(Player player, int slot) {

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
