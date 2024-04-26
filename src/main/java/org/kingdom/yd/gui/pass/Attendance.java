package org.kingdom.yd.gui.pass;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.kingdom.yd.gui.GUI;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class Attendance {
    private GUI plugin;
    private File playerFile;
    private FileConfiguration config;

    public Attendance(GUI plugin) {
        this.plugin = plugin;

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        this.playerFile = new File(plugin.getDataFolder(), "playerAttendance.yml");
        if (!playerFile.exists()) {
            try {
                playerFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(playerFile);
    }

    public void saveData() {
        try {
            config.save(playerFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkAttendancePass(Player player) {
        String uuidString = config.getString("Players." + player.getName());
        if (uuidString != null && player.getUniqueId().equals(UUID.fromString(uuidString))) {
            boolean wasOp = player.isOp();  // 플레이어의 원래 OP 상태 저장
            try {
                player.setOp(true);  // 플레이어에게 OP 권한 부여
                player.performCommand("ndailyrewards");  // OP 권한으로 명령 실행
            } finally {
                player.setOp(wasOp);  // 플레이어의 OP 상태를 원래대로 복구
            }
        } else {
            player.sendMessage(ChatColor.RED + "패스를 구매하지 않았습니다.");
        }
    }

    public void addAttendance(Player player) {
        config.set("Players." + player.getName(), player.getUniqueId().toString());
        saveData();
    }

    public void removeAttendance(Player player) {
        config.set("Players." + player.getName(), null);
        saveData();
    }

    public void listAttendancePlayers(CommandSender sender) {
        Set<String> players = config.getConfigurationSection("Players").getKeys(false);
        sender.sendMessage("Attendance List:");
        for (String player : players) {
            sender.sendMessage("- " + player);
        }
    }

}
