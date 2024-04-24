package usd.jedzius.crispyserver.packet.callback;

import java.util.function.Consumer;

public interface Callback {
    Consumer<Object> handleCallback();
}
