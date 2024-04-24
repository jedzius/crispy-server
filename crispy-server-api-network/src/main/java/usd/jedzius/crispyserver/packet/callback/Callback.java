package usd.jedzius.crispyserver.packet.callback;

import java.util.function.Consumer;

public interface Callback<T> {
    Consumer<T> handleCallback();
}
