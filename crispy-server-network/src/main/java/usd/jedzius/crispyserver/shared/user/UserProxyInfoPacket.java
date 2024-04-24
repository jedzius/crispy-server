package usd.jedzius.crispyserver.shared.user;

import usd.jedzius.crispyserver.packet.callback.Callback;
import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

import java.util.UUID;
import java.util.function.Consumer;

public class UserProxyInfoPacket extends ProtocolPacket implements Callback<String> {

    private final UUID uniqueId;

    public UserProxyInfoPacket(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public Consumer<String> handleCallback() {
        return object -> {
            System.out.println("your proxy is: " + object);
        };
    }
}
