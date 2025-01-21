package me.ooo7Oneu.discordWebHookSpigot;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DiscordWebHookSpigot extends JavaPlugin {

    public static DiscordWebHookSpigot instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("DiscordWebHook-spigotが正常にロードされました。");
        Bukkit.getLogger().info("[DiscordWebHook] version:" + checkVersion());

        saveDefaultConfig();
        Config.upload();

        SendEmbed.onStartServer();

        setInstance(this);

        getServer().getPluginManager().registerEvents(new EventListener(), this);

        getCommand("dwh").setExecutor(new DWH());

        instance = this;

    }

    public static DiscordWebHookSpigot getInstance() {
        return getPlugin(DiscordWebHookSpigot.class);
    }

    private static void setInstance(DiscordWebHookSpigot instance) {
        DiscordWebHookSpigot.instance = instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        SendEmbed.onStopServer();
    }

    static String checkVersion() { return "1.0"; }
}
