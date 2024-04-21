package usd.jedzius.crispyserver;

public abstract class NetworkHandler<T extends NetworkPacket> {
    public abstract void handle(T packet);
}
