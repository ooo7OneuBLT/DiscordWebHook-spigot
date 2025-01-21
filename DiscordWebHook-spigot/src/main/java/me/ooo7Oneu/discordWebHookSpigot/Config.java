package me.ooo7Oneu.discordWebHookSpigot;

import org.bukkit.plugin.java.JavaPlugin;

public class Config extends JavaPlugin {
    public static void upload() {
        if (!(DiscordWebHookSpigot.getInstance().getConfig().contains("url"))) {
            DiscordWebHookSpigot.getInstance().getConfig().set("url", "null");
        }
        if (!DiscordWebHookSpigot.getInstance().getConfig().contains("serverName")) {
            DiscordWebHookSpigot.getInstance().getConfig().set("serverName", "serverName");
        }
        if (!DiscordWebHookSpigot.getInstance().getConfig().contains("notification.serverStart")) {
            DiscordWebHookSpigot.getInstance().getConfig().set("notification.serverStart", true);
        }
        if (!DiscordWebHookSpigot.getInstance().getConfig().contains("notification.serverStop")) {
            DiscordWebHookSpigot.getInstance().getConfig().set("notification.serverStop", true);
        }
        if (!DiscordWebHookSpigot.getInstance().getConfig().contains("notification.playerJoin")) {
            DiscordWebHookSpigot.getInstance().getConfig().set("notification.playerJoin", true);
        }
        if (!DiscordWebHookSpigot.getInstance().getConfig().contains("notification.playerQuit")) {
            DiscordWebHookSpigot.getInstance().getConfig().set("notification.playerQuit", true);
        }
    }
}
