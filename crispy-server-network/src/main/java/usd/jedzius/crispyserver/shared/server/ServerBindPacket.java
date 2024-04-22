package usd.jedzius.crispyserver.shared.server;

import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

public class ServerBindPacket extends ProtocolPacket {
    private final String serverName;

    public ServerBindPacket(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }
}
