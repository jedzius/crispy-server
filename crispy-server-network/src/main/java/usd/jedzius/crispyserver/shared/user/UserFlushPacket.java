package usd.jedzius.crispyserver.shared.user;

import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

import java.util.UUID;

public class UserFlushPacket extends ProtocolPacket {
    private final UUID uniqueId;

    public UserFlushPacket(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }
}
