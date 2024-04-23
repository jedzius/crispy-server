package usd.jedzius.crispyserver.client;

import usd.jedzius.crispyserver.packet.NetworkPacket;

import java.io.IOException;

public interface NetworkClient {
    void connect() throws IOException;
    void start();
    void close();
    void send(NetworkPacket packet);
}
