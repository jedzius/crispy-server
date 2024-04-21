package usd.jedzius.crispyserver.packet;

public abstract class NetworkPacket {
    private final long id;

    protected NetworkPacket(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
