package usd.jedzius.crispyserver.shared.server;

import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

public class ServerUnBindPacket extends ProtocolPacket {
    private final String serverName;

    public ServerUnBindPacket(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }
}
