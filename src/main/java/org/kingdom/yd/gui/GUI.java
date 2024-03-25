package org.kingdom.yd.gui;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.kingdom.yd.gui.menu.MenuCommand;
import org.kingdom.yd.gui.menu.MenuListener;

public final class GUI extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("menu").setExecutor(new MenuCommand());
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
