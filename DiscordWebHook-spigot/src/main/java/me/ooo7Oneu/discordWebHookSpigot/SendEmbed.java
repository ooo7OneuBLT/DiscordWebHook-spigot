package me.ooo7Oneu.discordWebHookSpigot;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class SendEmbed {

    public static void onStartServer() {
        if (DiscordWebHookSpigot.getInstance().getConfig().getBoolean("notification.serverStart")) {
            if (DiscordWebHookSpigot.getInstance().getConfig().getString("url") != null) {
                if (!Objects.requireNonNull(DiscordWebHookSpigot.getInstance().getConfig().getString("url")).equals("null")) {

                    DiscordWebhook webhook = new DiscordWebhook(DiscordWebHookSpigot.getInstance().getConfig().getString("url"));
                    webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription(DiscordWebHookSpigot.getInstance().getConfig().getString("serverName") + "サーバーが起動されました。").setColor(new Color(52, 235, 76)));

                    try {
                        webhook.execute();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    Bukkit.getLogger().info("ERROR: config.yml の url が設定されていません。");
                }
            } else {
                Bukkit.getLogger().info("ERROR: config.yml の url が null です。");
            }
        }
    }

    public static void onStopServer() {

        if (DiscordWebHookSpigot.getInstance().getConfig().getBoolean("notification.serverStop")) {

            if (DiscordWebHookSpigot.getInstance().getConfig().getString("url") != null) {
                if (!Objects.requireNonNull(DiscordWebHookSpigot.getInstance().getConfig().getString("url")).equals("null")) {

                    DiscordWebhook webhook = new DiscordWebhook(DiscordWebHookSpigot.getInstance().getConfig().getString("url"));
                    webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription(DiscordWebHookSpigot.getInstance().getConfig().getString("serverName") + "サーバーが停止されました。").setColor(new Color(227, 0, 0)));

                    try {
                        webhook.execute();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    Bukkit.getLogger().info("ERROR: config.yml の url が設定されていません。");
                }
            } else {
                Bukkit.getLogger().info("ERROR: config.yml の url が null です。");
            }
        }
    }

    public static void onPlayerJoin(Player player) {

        if (DiscordWebHookSpigot.getInstance().getConfig().getBoolean("notification.playerJoin")) {
            DiscordWebhook webhook = new DiscordWebhook(DiscordWebHookSpigot.getInstance().getConfig().getString("url"));
            webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription("**" + player.getDisplayName() + "** が" + DiscordWebHookSpigot.getInstance().getConfig().getString("serverName") + "に参加しました。").setColor(new Color(58, 242, 212)));

            try {
                webhook.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void onPlayerQuit(Player player) {

        if (DiscordWebHookSpigot.getInstance().getConfig().getBoolean("notification.playerQuit")) {
            DiscordWebhook webhook = new DiscordWebhook(DiscordWebHookSpigot.getInstance().getConfig().getString("url"));
            webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription("**" + player.getDisplayName() + "** が" + DiscordWebHookSpigot.getInstance().getConfig().getString("serverName") + "を退出しました。").setColor(new Color(250, 112, 57)));

            try {
                webhook.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
