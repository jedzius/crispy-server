package usd.jedzius.crispyserver;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import usd.jedzius.crispyserver.client.NetworkClient;
import usd.jedzius.crispyserver.command.ProxyCommand;
import usd.jedzius.crispyserver.handler.player.PlayerConnectionHandler;
import usd.jedzius.crispyserver.protocol.client.ProtocolClient;
import usd.jedzius.crispyserver.shared.server.ServerBindPacket;
import usd.jedzius.crispyserver.shared.server.ServerUnBindPacket;
import usd.jedzius.crispyserver.user.SpigotPlatformUserService;

import java.io.IOException;

public class SpigotPlugin extends JavaPlugin {

    private final PluginManager PLUGIN_MANAGER = getServer().getPluginManager();;
    private NetworkClient protocolClient;
    private SpigotPlatformUserService spigotPlatformUserService;
    @Override
    public void onEnable() {
        this.spigotPlatformUserService = new SpigotPlatformUserService();

        this.protocolClient = new ProtocolClient(10000, 10001);
        this.protocolClient.start();

        try {
            this.protocolClient.connect();
            var packet = new ServerBindPacket("SERVER_1");
            this.protocolClient.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PLUGIN_MANAGER.registerEvents(new PlayerConnectionHandler(this), this);

        this.getCommand("proxy").setExecutor(new ProxyCommand(this));
    }

    @Override
    public void onDisable() {
        var packet = new ServerUnBindPacket("SERVER_1");
        this.protocolClient.send(packet);
    }

    public NetworkClient getProtocolClient() {
        return protocolClient;
    }

    public SpigotPlatformUserService getSpigotPlatformUserService() {
        return spigotPlatformUserService;
    }
}
