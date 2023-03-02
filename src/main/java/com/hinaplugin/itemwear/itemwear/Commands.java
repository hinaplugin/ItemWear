package com.hinaplugin.itemwear.itemwear;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1){
            if (args[0].equalsIgnoreCase("reload")){
                ItemWear.getPlugin().reloadConfig();
            }
        }
        return false;
    }
}
