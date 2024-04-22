package usd.jedzius.crispyserver.shared.user;

import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

public class UserCreatePacket extends ProtocolPacket {
    private final String nickname;

    public UserCreatePacket(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
