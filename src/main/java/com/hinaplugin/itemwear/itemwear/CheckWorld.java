package com.hinaplugin.itemwear.itemwear;

import org.bukkit.entity.Player;

import java.util.List;

public class CheckWorld {

    public boolean Check(final Player player){
        final List<String> worlds = ItemWear.getPlugin().getConfig().getStringList("world");
        return worlds.contains(player.getWorld().getName());
    }
}
