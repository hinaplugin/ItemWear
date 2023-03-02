package com.hinaplugin.itemwear.itemwear;

import org.bukkit.command.PluginCommand;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ItemWear extends JavaPlugin {
    private static ItemWear plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            plugin = this;

            final File configFile = new File(getDataFolder(), "config.yml");
            if (!configFile.exists()){
                this.saveDefaultConfig();
            }

            final PluginCommand command = getCommand("iw");
            if (command != null){
                command.setExecutor(new Commands());
            }

            getServer().getPluginManager().registerEvents(new InventoryClick(), this);

            getLogger().info("ItemWear is Enabled!");
        }catch (final Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try {
            HandlerList.unregisterAll(this);
            getLogger().info("ItemWear is Disabled!");
        }catch (final Exception exception){
            exception.printStackTrace();
        }
    }

    public static ItemWear getPlugin(){ return plugin; }
}
