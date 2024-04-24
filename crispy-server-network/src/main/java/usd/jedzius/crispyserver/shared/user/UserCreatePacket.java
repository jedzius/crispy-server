package usd.jedzius.crispyserver.shared.user;

import usd.jedzius.crispyserver.packet.callback.Callback;
import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;
import java.util.UUID;
import java.util.function.Consumer;


public class UserCreatePacket extends ProtocolPacket implements Callback {
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

    @Override
    public Consumer<Object> handleCallback() {
        return integer -> {
            System.out.println("ELO to jest callback od usercreatepacket");
        };
    }
}
