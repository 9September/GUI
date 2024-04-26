package org.kingdom.yd.gui.pass;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LevelCommand implements CommandExecutor {
    private Level level;

    public LevelCommand(Level level) {
        this.level = level;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage("§cYou do not have permission to use this command.");
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        if (args.length > 1) {
            String playerName = args[1];
            Player targetPlayer = sender.getServer().getPlayer(playerName);
            if (targetPlayer == null) {
                sender.sendMessage("Player not found.");
                return true;
            }
            switch (args[0].toLowerCase()) {
                case "add":
                    level.addLevel(targetPlayer);
                    sender.sendMessage(playerName + " has been added to the level list.");
                    return true;
                case "remove":
                    level.removeLevel(targetPlayer);
                    sender.sendMessage(playerName + " has been removed from the level list.");
                    return true;
                default:
                    return false;
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
            level.listLevelPlayers(sender);
            return true;
        }
        sender.sendMessage("Usage: /level <add|remove|list> <playername>");

        return false;
    }
}
