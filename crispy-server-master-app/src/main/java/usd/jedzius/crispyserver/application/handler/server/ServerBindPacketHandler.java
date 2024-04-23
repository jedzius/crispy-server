package usd.jedzius.crispyserver.application.handler.server;

import usd.jedzius.crispyserver.application.server.MasterPlatformServerService;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.server.ServerBindPacket;

public class ServerBindPacketHandler extends ProtocolPacketHandler<ServerBindPacket> {

    private final MasterPlatformServerService serverService;

    public ServerBindPacketHandler(MasterPlatformServerService serverService) {
        super(ServerBindPacket.class);
        this.serverService = serverService;
    }

    @Override
    public void execute(ServerBindPacket packet) {
        this.serverService.search(packet.getServerName()).ifPresent(platformServer -> {
            platformServer.setEnabled(true);
            System.out.println("[INFO] Found server (" + packet.getServerName() + ") and marked it as enabled!");
        });
    }
}
