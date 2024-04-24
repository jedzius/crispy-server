package usd.jedzius.crispyserver.shared.user;

import usd.jedzius.crispyserver.packet.callback.Callback;
import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;
import java.util.UUID;
import java.util.function.Consumer;


public class UserCreatePacket extends ProtocolPacket implements Callback {
    private final UUID uniqueId;
    private final String nickname;

    private final String proxyName;
    public UserCreatePacket(UUID uniqueId, String nickname, String proxyName) {
        this.uniqueId = uniqueId;
        this.nickname = nickname;
        this.proxyName = proxyName;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProxyName() {
        return proxyName;
    }

    @Override
    public Consumer<Object> handleCallback() {
        return integer -> {
            System.out.println("ELO to jest callback od usercreatepacket");
        };
    }
}
