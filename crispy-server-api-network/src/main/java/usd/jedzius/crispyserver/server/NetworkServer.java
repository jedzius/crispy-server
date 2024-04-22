package usd.jedzius.crispyserver.server;

import java.io.IOException;

public interface NetworkServer {
    void connect() throws IOException;
    void start();
}
