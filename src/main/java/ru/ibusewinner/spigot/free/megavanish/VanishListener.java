package ru.ibusewinner.spigot.free.megavanish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class VanishListener implements Listener {

    protected static List<Player> vanished = new ArrayList<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        for(Player pp : Bukkit.getOnlinePlayers()) {
            if(vanished.contains(pp)) {
                if(!p.hasPermission("megavanish.see")) {
                    p.hidePlayer(pp);
                }
            }
        }
    }

}
