package usd.jedzius.crispyserver.application.handler.proxy;

import com.esotericsoftware.kryonet.Connection;
import usd.jedzius.crispyserver.application.proxy.MasterPlatformProxyService;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.proxy.ProxyBindPacket;

public class ProxyBindPacketHandler extends ProtocolPacketHandler<ProxyBindPacket> {

    private final MasterPlatformProxyService masterPlatformProxyService;

    public ProxyBindPacketHandler(MasterPlatformProxyService masterPlatformProxyService) {
        super(ProxyBindPacket.class);
        this.masterPlatformProxyService = masterPlatformProxyService;
    }

    @Override
    public void execute(ProxyBindPacket packet, Connection connection) {
        this.masterPlatformProxyService.search(packet.getProxyName()).ifPresent(platformProxy -> {
            platformProxy.setEnabled(true);
            System.out.println("[INFO] Found proxy (" + packet.getProxyName() + ") and marked it as enabled!");
        });
    }
}
