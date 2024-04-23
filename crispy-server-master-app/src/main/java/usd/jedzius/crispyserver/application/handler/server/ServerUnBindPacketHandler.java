package usd.jedzius.crispyserver.application.handler.server;

import usd.jedzius.crispyserver.application.server.MasterPlatformServerService;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.server.ServerUnBindPacket;

public class ServerUnBindPacketHandler extends ProtocolPacketHandler<ServerUnBindPacket> {

    private final MasterPlatformServerService masterPlatformServerService;

    public ServerUnBindPacketHandler(MasterPlatformServerService masterPlatformServerService) {
        super(ServerUnBindPacketHandler.class);
        this.masterPlatformServerService = masterPlatformServerService;
    }

    @Override
    public void execute(ServerUnBindPacket packet) {
        this.masterPlatformServerService.search(packet.getServerName()).ifPresent(masterPlatformServer -> {
            masterPlatformServer.setEnabled(false);
            System.out.println("[INFO] Found server (" + packet.getServerName() + ") and marked it as disabled!");
        });
    }
}
