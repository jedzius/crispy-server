package usd.jedzius.crispyserver.service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractService<V, T> {
    private final Map<V, T> objectMap = new ConcurrentHashMap<>();

    public void put(V value, T type) {
        this.objectMap.put(value, type);
        System.out.println("[INFO] Found server and loaded it into cache!");
    }

    public Optional<T> search(V value) {
        return Optional.ofNullable(this.objectMap.get(value));
    }
}
