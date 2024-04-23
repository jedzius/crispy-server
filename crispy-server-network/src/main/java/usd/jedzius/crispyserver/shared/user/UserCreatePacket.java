package usd.jedzius.crispyserver.shared.user;

import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

import java.util.UUID;

public class UserCreatePacket extends ProtocolPacket {
    private final UUID uniqueId;
    private final String nickname;

    public UserCreatePacket(UUID uniqueId, String nickname) {
        this.uniqueId = uniqueId;
        this.nickname = nickname;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getNickname() {
        return nickname;
    }
}
