package org.kingdom.yd.gui.pass;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AttendanceCommand implements CommandExecutor {
    private Attendance attendance;

    public AttendanceCommand(Attendance attendance) {
        this.attendance = attendance;
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

        if (args.length > 1) {  // 명령어와 플레이어 이름이 필요
            String playerName = args[1];
            Player targetPlayer = sender.getServer().getPlayer(playerName);
            if (targetPlayer == null) {
                sender.sendMessage("Player not found.");
                return true;
            }
            switch (args[0].toLowerCase()) {
                case "add":
                    attendance.addAttendance(targetPlayer);
                    sender.sendMessage(playerName + " has been added to the attendance list.");
                    return true;
                case "remove":
                    attendance.removeAttendance(targetPlayer);
                    sender.sendMessage(playerName + " has been removed from the attendance list.");
                    return true;
                default:
                    return false;
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("list")) {  // 인자가 'list' 하나일 때
            attendance.listAttendancePlayers(sender);
            return true;
        }
        sender.sendMessage("Usage: /attendance <add|remove|list> <playername>");
        return false;
    }
}
