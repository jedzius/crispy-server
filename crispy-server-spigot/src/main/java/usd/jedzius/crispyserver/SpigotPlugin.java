package usd.jedzius.crispyserver;

import org.bukkit.plugin.java.JavaPlugin;
import usd.jedzius.crispyserver.protocol.client.ProtocolClient;
import usd.jedzius.crispyserver.shared.server.ServerBindPacket;
import usd.jedzius.crispyserver.shared.server.ServerUnBindPacket;

import java.io.IOException;

public class SpigotPlugin extends JavaPlugin {

    private ProtocolClient protocolClient;

    @Override
    public void onEnable() {
        this.protocolClient = new ProtocolClient(10000, 10001);
        this.protocolClient.start();

        try {
            this.protocolClient.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var packet = new ServerBindPacket("SERVER_1");
        this.protocolClient.send(packet);
    }

    @Override
    public void onDisable() {
        var packet = new ServerUnBindPacket("SERVER_1");
        this.protocolClient.send(packet);
    }
}
