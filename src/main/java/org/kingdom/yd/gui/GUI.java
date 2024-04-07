package org.kingdom.yd.gui;

import org.bukkit.plugin.java.JavaPlugin;

public final class GUI extends JavaPlugin {

    @Override
    public void onEnable() {
        GUIManager guiManager = new GUIManager(this);

        getCommand("menu").setExecutor(guiManager);
        getServer().getPluginManager().registerEvents(guiManager, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
