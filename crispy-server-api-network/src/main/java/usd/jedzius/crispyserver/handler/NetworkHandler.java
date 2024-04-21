package usd.jedzius.crispyserver.handler;

import usd.jedzius.crispyserver.packet.NetworkPacket;

public abstract class NetworkHandler<T extends NetworkPacket> {
    public abstract void handle(T packet);
}
