package usd.jedzius.crispyserver.protocol.packet.callback;

import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

public class CallbackPacket extends ProtocolPacket {

    private final long packetId;
    private final Object replacement;
    public CallbackPacket(long id, Object replacement) {
        this.packetId = id;
        this.replacement = replacement;
    }

    public Object getReplacement() {
        return replacement;
    }

    public long getPacketId() {
        return packetId;
    }
}
