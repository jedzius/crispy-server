package usd.jedzius.crispyserver.application.handler.proxy;

import com.esotericsoftware.kryonet.Connection;
import usd.jedzius.crispyserver.application.proxy.MasterPlatformProxyService;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.proxy.ProxyUnBindPacket;

public class ProxyUnBindPacketHandler extends ProtocolPacketHandler<ProxyUnBindPacket> {

    private final MasterPlatformProxyService masterPlatformProxyService;

    public ProxyUnBindPacketHandler(MasterPlatformProxyService masterPlatformProxyService) {
        super(ProxyUnBindPacket.class);
        this.masterPlatformProxyService = masterPlatformProxyService;
    }

    @Override
    public void execute(ProxyUnBindPacket packet, Connection connection) {
        this.masterPlatformProxyService.search(packet.getProxyName()).ifPresent(masterPlatformProxy -> {
            masterPlatformProxy.setEnabled(false);
            System.out.println("[INFO] Found proxy (" + packet.getProxyName() + ") and marked it as disabled!");
        });
    }
}
