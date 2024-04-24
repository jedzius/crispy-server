package usd.jedzius.crispyserver.protocol.packet.callback;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import usd.jedzius.crispyserver.packet.NetworkPacket;
import usd.jedzius.crispyserver.packet.callback.Callback;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class CallbackService {
    private final Cache<Long, Consumer<Object>> callBacks = CacheBuilder
            .newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build();

    public void put(NetworkPacket packet) {
        this.callBacks.put(packet.getId(), ((Callback)packet).handleCallback());
    }

    public void flush(long id) {
        this.callBacks.asMap().remove(id);
    }

    public Optional<Consumer<Object>> search(long id) {
        return Optional.ofNullable(this.callBacks.asMap().get(id));
    }
}
