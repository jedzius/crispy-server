package usd.jedzius.crispyserver.handler;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.proxy.Player;
import usd.jedzius.crispyserver.ProxyPlugin;
import usd.jedzius.crispyserver.shared.user.UserCreatePacket;
import usd.jedzius.crispyserver.shared.user.UserFlushPacket;

public class PlayerConnectionHandler {

    private final ProxyPlugin proxyPlugin;

    public PlayerConnectionHandler(ProxyPlugin proxyPlugin) {
        this.proxyPlugin = proxyPlugin;
    }

    @Subscribe
    public void onJoin(PostLoginEvent event) {
        final Player player = event.getPlayer();
        this.proxyPlugin.getProtocolClient().send(new UserCreatePacket(player.getUniqueId(), player.getUsername(), "PROXY_1"));
    }

    @Subscribe
    public void onQuit(DisconnectEvent event) {
        final Player player = event.getPlayer();
        this.proxyPlugin.getProtocolClient().send(new UserFlushPacket(player.getUniqueId()));
    }
}
