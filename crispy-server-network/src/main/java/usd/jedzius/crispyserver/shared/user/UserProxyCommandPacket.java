package usd.jedzius.crispyserver.shared.user;

import org.bukkit.Bukkit;
import usd.jedzius.crispyserver.packet.callback.Callback;
import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

public class UserProxyCommandPacket extends ProtocolPacket implements Callback<String> {

    private final UUID uniqueId;

    public UserProxyCommandPacket(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public Consumer<String> handleCallback() {
        return object -> {
            String[] data = object.split(":");
            var player = Bukkit.getPlayer(UUID.fromString(data[0]));
            if(Objects.isNull(player))
                return;

            player.sendMessage("your proxy is " + data[1]);
        };
    }
}
