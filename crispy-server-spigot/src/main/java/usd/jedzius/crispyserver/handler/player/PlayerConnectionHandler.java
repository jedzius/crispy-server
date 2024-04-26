package usd.jedzius.crispyserver.handler.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import usd.jedzius.crispyserver.SpigotPlugin;
import usd.jedzius.crispyserver.user.SpigotPlatformUser;

public class PlayerConnectionHandler implements Listener {

    private final SpigotPlugin plugin;

    public PlayerConnectionHandler(SpigotPlugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onLogin(final PlayerLoginEvent event) {
        var uniqueId = event.getPlayer().getUniqueId();
        this.plugin.getSpigotPlatformUserService().search(uniqueId).ifPresentOrElse(spigotPlatformUser -> {
            System.out.println("found player profile");
        }, () -> this.plugin.getSpigotPlatformUserService().put(uniqueId, new SpigotPlatformUser(uniqueId)));
    }


    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        var player = event.getPlayer();
        this.plugin.getSpigotPlatformUserService().search(player.getUniqueId()).ifPresent(spigotPlatformUser -> {
            player.sendMessage("server powered by crispy-server ;D");
        });
    }
}
