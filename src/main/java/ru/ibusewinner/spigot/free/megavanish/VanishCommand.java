package ru.ibusewinner.spigot.free.megavanish;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
        if(!(s instanceof Player)) {
            s.sendMessage("§cКоманда доступна только игрокам!");
            return false;
        }

        Player p = (Player)s;

        if(!p.hasPermission("megavanish.use")) {
            p.sendMessage("§cУ Вас недостаточно прав!");
            return false;
        }

        if(VanishListener.vanished.contains(p)) {
            VanishListener.vanished.remove(p);
            for(Player pp : Bukkit.getOnlinePlayers()) {
                pp.showPlayer(p);
            }
            p.sendMessage("§aВы показались другим игрокам!");
        } else {
            VanishListener.vanished.add(p);
            for(Player pp : Bukkit.getOnlinePlayers()) {
                if(!pp.hasPermission("megavanish.see")) {
                    pp.hidePlayer(p);
                }

            }
            p.sendMessage("§aВы успешно скрылись от остальных игроков!");
        }

        return true;
    }
}
