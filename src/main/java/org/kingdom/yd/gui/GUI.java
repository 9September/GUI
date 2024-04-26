package org.kingdom.yd.gui;

import org.bukkit.plugin.java.JavaPlugin;
import org.kingdom.yd.gui.pass.Attendance;
import org.kingdom.yd.gui.pass.AttendanceCommand;
import org.kingdom.yd.gui.pass.Level;
import org.kingdom.yd.gui.pass.LevelCommand;

public final class GUI extends JavaPlugin {

    @Override
    public void onEnable() {
        GUIManager guiManager = new GUIManager(this);
        Attendance attendance = new Attendance(this);
        Level level = new Level(this);

        getCommand("menu").setExecutor(guiManager);
        getCommand("attendance").setExecutor(new AttendanceCommand(attendance));
        getCommand("level").setExecutor(new LevelCommand(level));
        getServer().getPluginManager().registerEvents(guiManager, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
