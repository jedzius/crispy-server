package usd.jedzius.crispyserver;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import usd.jedzius.crispyserver.client.NetworkClient;
import usd.jedzius.crispyserver.handler.PlayerConnectionHandler;
import usd.jedzius.crispyserver.protocol.client.ProtocolClient;
import usd.jedzius.crispyserver.shared.proxy.ProxyBindPacket;
import usd.jedzius.crispyserver.shared.proxy.ProxyUnBindPacket;

import java.io.IOException;

@Plugin(id = "crispy-server-proxy", name = "crispy-server-proxy", version = "1.0", authors = {"jedzius"})
public class ProxyPlugin {

    private final NetworkClient protocolClient;

    private final ProxyServer server;
    @Inject
    public ProxyPlugin(ProxyServer server) {
        this.server = server;

        this.protocolClient = new ProtocolClient(10000, 10001);
        this.protocolClient.start();


    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        this.bindToMaster();

        this.server.getEventManager().register(this, new PlayerConnectionHandler(this));
    }

    @Subscribe
    public void onShutdown(ProxyShutdownEvent event) {
        this.unBindToMaster();
    }

    private void bindToMaster() {
        try {
            this.protocolClient.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final ProxyBindPacket bindingPacket = new ProxyBindPacket("PROXY_1");
        this.protocolClient.send(bindingPacket);
    }

    private void unBindToMaster() {
        final ProxyUnBindPacket unBindingPacket = new ProxyUnBindPacket("PROXY_1");
        this.protocolClient.send(unBindingPacket);
    }

    public NetworkClient getProtocolClient() {
        return protocolClient;
    }
}
