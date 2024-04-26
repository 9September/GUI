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

public class Level {
    private GUI plugin;
    private File levelFile;
    private FileConfiguration config;

    public Level(GUI plugin) {
        this.plugin = plugin;

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        this.levelFile = new File(plugin.getDataFolder(), "playerLevel.yml");
        if (!levelFile.exists()) {
            try {
                levelFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(levelFile);
    }

    public void saveData() {
        try {
            config.save(levelFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkLevelPass(Player player) {
        String uuidString = config.getString("Players."+player.getName());
        if (uuidString != null && player.getUniqueId().equals(UUID.fromString(uuidString))) {
            return true;
        } else {
            player.sendMessage(ChatColor.RED + "패스를 구매하지 않았습니다.");
            return false;
        }
    }

    public void addLevel(Player player) {
        config.set("Players." + player.getName(), player.getUniqueId().toString());
        saveData();
    }

    public void removeLevel(Player player) {
        config.set("Players." + player.getName(), null);
        saveData();
    }

    public void listLevelPlayers(CommandSender sender) {
        Set<String> players = config.getConfigurationSection("Players").getKeys(false);
        sender.sendMessage("Level List:");
        for (String player : players) {
            sender.sendMessage("- " + player);
        }
    }

    public int getRequiredLevel(int slot) {
        switch (slot) {
            case 11: return 5;
            case 13: return 10;
            case 15: return 15;
            case 19: return 20;
            case 21: return 25;
            case 23: return 30;
            case 25: return 35;
            case 29: return 40;
            case 31: return 45;
            case 33: return 50;
            default: return 0;  // Default case should ideally never be used
        }
    }

    public boolean hasReceivedReward(Player player, int level) {
        return config.getBoolean("Players." + player.getUniqueId().toString() + ".Rewards.Level" + level, false);
    }

    public void markRewardAsReceived(Player player, int level) {
        config.set("Players." + player.getUniqueId().toString() + ".Rewards.Level" + level, true);
        saveData();
    }


}
