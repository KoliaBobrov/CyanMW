package ru.cyanworld.cyanmw;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public org.bukkit.Server server;
    public FileConfiguration config;
    public ru.cyanworld.cyanmw.Items items;

    @Override
    public void onEnable() {
        server = getServer();
        try {
            config = getConfig();
            config.loadFromString(config.saveToString().replaceAll("&", "§"));
            saveDefaultConfig();
            items = new Items(this);
        } catch (Exception ex) {
            ex.printStackTrace();
            server.shutdown();
        }
    }

    @Override
    public void onDisable() {
        //Do something
    }
}
