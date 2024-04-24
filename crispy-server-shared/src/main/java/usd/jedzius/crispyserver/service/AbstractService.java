package usd.jedzius.crispyserver.service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractService<V, T> {
    private final Map<V, T> objectMap = new ConcurrentHashMap<>();

    public void put(V value, T type) {
        this.objectMap.put(value, type);
    }

    public void flush(V v) {
        this.objectMap.remove(v);
    }

    public Optional<T> search(V value) {
        return Optional.ofNullable(this.objectMap.get(value));
    }
}
