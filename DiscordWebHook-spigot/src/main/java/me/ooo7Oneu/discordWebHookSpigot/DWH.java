package me.ooo7Oneu.discordWebHookSpigot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DWH implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("dwh")) {
            if (strings.length == 0) {
                commandSender.sendMessage("§4/dwh <subcommands>");
                return false;
            } else if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("reload")) {
                    DiscordWebHookSpigot.getInstance().reloadConfig();
                    commandSender.sendMessage("§6プラグインをリロードしました。");
                    return true;
                } else {
                    commandSender.sendMessage("§4/dwh <サブコマンド>");
                    return false;
                }
            }
        }
        return false;
    }
}
