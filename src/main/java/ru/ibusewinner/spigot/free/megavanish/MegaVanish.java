package ru.ibusewinner.spigot.free.megavanish;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MegaVanish extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new VanishListener(), this);
        Bukkit.getPluginCommand("vanish").setExecutor(new VanishCommand());
        Bukkit.getLogger().info("§aПлагин включен!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("§cПлагин выключен!");
    }
}
