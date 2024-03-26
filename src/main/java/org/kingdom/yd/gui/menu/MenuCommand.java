package org.kingdom.yd.gui.menu;

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

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            Inventory inv = Bukkit.createInventory(player, 54, ChatColor.YELLOW.toString() + ChatColor.BOLD + "KINGDOM ONLINE");

            //Spawn
            ItemStack spawn = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta spawnMeta = spawn.getItemMeta();
            spawnMeta.setDisplayName(ChatColor.RED + "스폰으로 이동하기");
            spawnMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 스폰으로 이동합니다."));
            spawn.setItemMeta(spawnMeta);

            for (int i : new int[] {0,1,2,9,10,11}) {
                inv.setItem(i,spawn);
            }

            //Core
            ItemStack core = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
            ItemMeta coreMeta = core.getItemMeta();
            coreMeta.setDisplayName(ChatColor.GOLD + "내 코어 보기");
            coreMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 내 코어를 확인합니다."));
            core.setItemMeta(coreMeta);

            for (int i : new int[] {3,4,5,12,13,14}) {
                inv.setItem(i,core);
            }

            //Wild
            ItemStack field = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
            ItemMeta fieldMeta = field.getItemMeta();
            fieldMeta.setDisplayName(ChatColor.YELLOW + "필드로 이동하기");
            fieldMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 필드를 선택할 수 있습니다."));
            fieldMeta.setLore(Arrays.asList(ChatColor.GRAY + "야생필드와 몬스터필드가 존재합니다."));
            field.setItemMeta(fieldMeta);

            for (int i : new int[] {6,7,8,15,16,17}) {
                inv.setItem(i,field);
            }

            //Store
            ItemStack store = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            ItemMeta storeMeta = store.getItemMeta();
            storeMeta.setDisplayName(ChatColor.GREEN + "상점으로 이동하기");
            storeMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 상점을 확인합니다."));
            store.setItemMeta(storeMeta);

            for (int i : new int[] {18,19,20,27,28,29}) {
                inv.setItem(i,store);
            }

            //Quest
            ItemStack quest = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
            ItemMeta questMeta = quest.getItemMeta();
            questMeta.setDisplayName(ChatColor.BLUE + "퀘스트 확인하기");
            questMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 내 퀘스트 정보를 확인할 수 있습니다."));
            quest.setItemMeta(questMeta);

            for (int i : new int[] {21,22,23,30,31,32}) {
                inv.setItem(i,quest);
            }

            //Pass
            ItemStack pass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            ItemMeta passMeta = pass.getItemMeta();
            passMeta.setDisplayName(ChatColor.DARK_PURPLE + "패스 오픈하기");
            passMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 패스를 확인할 수 있습니다."));
            passMeta.setLore(Arrays.asList(ChatColor.GRAY + "패스로는 출석패스, 레벨패스, 퀘스트패스, 접속시간패스, 누적시간패스가 있습니다."));
            pass.setItemMeta(passMeta);

            for (int i : new int[] {24,25,26,33,34,35}) {
                inv.setItem(i,pass);
            }

            //reinforce
            ItemStack reinforce = new ItemStack(Material.GLASS_PANE);
            ItemMeta reinforceMeta = reinforce.getItemMeta();
            reinforceMeta.setDisplayName(ChatColor.WHITE + "강화");
            reinforceMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 강화소로 이동합니다."));
            reinforce.setItemMeta(reinforceMeta);

            for (int i : new int[] {36,45}) {
                inv.setItem(i,reinforce);
            }

            //guild
            ItemStack guild = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta guildMeta = guild.getItemMeta();
            guildMeta.setDisplayName(ChatColor.WHITE + "길드");
            guildMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 모험가 길드로 이동합니다."));
            guild.setItemMeta(guildMeta);

            for (int i : new int[] {37,46}) {
                inv.setItem(i,guild);
            }

            //evolution
            ItemStack minigame = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            ItemMeta minigameMeta = minigame.getItemMeta();
            minigameMeta.setDisplayName(ChatColor.WHITE + "미니게임");
            minigameMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 미니게임을 오픈합니다."));
            minigame.setItemMeta(minigameMeta);

            for (int i : new int[] {38,47}) {
                inv.setItem(i,minigame);
            }

            //pvp
            ItemStack pvp = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta pvpMeta = pvp.getItemMeta();
            pvpMeta.setDisplayName(ChatColor.WHITE + "PVP");
            pvpMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 콜로세움으로 이동합니다."));
            pvp.setItemMeta(pvpMeta);

            for (int i : new int[] {39,48}) {
                inv.setItem(i,pvp);
            }

            //library
            ItemStack library = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE);
            ItemMeta libraryMeta = library.getItemMeta();
            libraryMeta.setDisplayName(ChatColor.WHITE + "도서관");
            libraryMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 도서관으로 이동합니다."));
            library.setItemMeta(libraryMeta);

            for (int i : new int[] {40,49}) {
                inv.setItem(i,library);
            }

            //challenge
            ItemStack challenge = new ItemStack(Material.BROWN_STAINED_GLASS_PANE);
            ItemMeta challengeMeta = challenge.getItemMeta();
            challengeMeta.setDisplayName(ChatColor.WHITE + "도전과제");
            challengeMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 도전과제를 확인합니다."));
            challenge.setItemMeta(challengeMeta);

            for (int i : new int[] {41,50}) {
                inv.setItem(i,challenge);
            }

            //skilltree
            ItemStack skilltree = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta skilltreeMeta = skilltree.getItemMeta();
            skilltreeMeta.setDisplayName(ChatColor.WHITE + "스킬트리");
            skilltreeMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 스킬트리를 확인합니다."));
            skilltree.setItemMeta(skilltreeMeta);

            for (int i : new int[] {42,51}) {
                inv.setItem(i,skilltree);
            }

            //tutorial
            ItemStack tutorial = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
            ItemMeta tutorialMeta = tutorial.getItemMeta();
            tutorialMeta.setDisplayName(ChatColor.WHITE + "튜토리얼");
            tutorialMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 튜토리얼로 이동합니다."));
            tutorial.setItemMeta(tutorialMeta);

            for (int i : new int[] {43,52}) {
                inv.setItem(i,tutorial);
            }

            //rank
            ItemStack rank = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta rankMeta = rank.getItemMeta();
            rankMeta.setDisplayName(ChatColor.WHITE + "랭킹");
            rankMeta.setLore(Arrays.asList(ChatColor.GRAY + "좌클릭 시 랭킹을 확인합니다."));
            rank.setItemMeta(rankMeta);

            for (int i : new int[] {44,53}) {
                inv.setItem(i,rank);
            }

            player.openInventory(inv);

        }

        return false;
    }
}
