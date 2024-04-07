package org.kingdom.yd.gui;

import com.earth2me.essentials.api.IWarps;
import com.earth2me.essentials.commands.WarpNotFoundException;
import net.ess3.api.IEssentials;
import net.ess3.api.InvalidWorldException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Warp {

    public void teleportToWarp(Player player, String warpName) {
        IEssentials essentials = (IEssentials) Bukkit.getPluginManager().getPlugin("Essentials");
        if (essentials != null) {
            try {
                IWarps warps =  essentials.getWarps();
                Location warpLocation = warps.getWarp(warpName);
                player.teleport(warpLocation);
            } catch (WarpNotFoundException e) {
                player.sendMessage("§cWarp " + warpName + " not found.");
                throw new RuntimeException(e);
            } catch (InvalidWorldException e) {
                player.sendMessage("§cThe world for warp " + warpName + " is not valid.");
                throw new RuntimeException(e);
            }
        } else {
            // Essentials 플러그인이 없을 경우
            player.sendMessage("§cEssentials plugin not found.");
        }
    }
}
