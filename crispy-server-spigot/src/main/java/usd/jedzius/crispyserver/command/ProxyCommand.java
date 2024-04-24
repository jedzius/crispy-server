package usd.jedzius.crispyserver.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import usd.jedzius.crispyserver.SpigotPlugin;
import usd.jedzius.crispyserver.shared.user.UserProxyInfoPacket;

public class ProxyCommand implements CommandExecutor {

    private final SpigotPlugin plugin;

    public ProxyCommand(SpigotPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player) {
            this.plugin.getProtocolClient().send(new UserProxyInfoPacket(player.getUniqueId()));
        }
        return false;
    }
}
