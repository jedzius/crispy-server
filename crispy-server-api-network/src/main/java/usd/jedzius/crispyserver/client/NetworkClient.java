package usd.jedzius.crispyserver.client;

import usd.jedzius.crispyserver.packet.NetworkPacket;

public interface NetworkClient {
    void connect();
    void close();
    void send(NetworkPacket packet);
}
