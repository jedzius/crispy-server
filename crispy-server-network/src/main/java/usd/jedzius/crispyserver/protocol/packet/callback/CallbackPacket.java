package usd.jedzius.crispyserver.protocol.packet.callback;

import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

public class CallbackPacket extends ProtocolPacket {

    private final long packetId;

    public CallbackPacket(long id) {
        this.packetId = id;
    }

    public long getPacketId() {
        return packetId;
    }
}
