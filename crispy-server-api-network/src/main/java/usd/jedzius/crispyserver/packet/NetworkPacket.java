package usd.jedzius.crispyserver.packet;

import java.io.Serializable;

public abstract class NetworkPacket implements Serializable {
    private final long id;

    protected NetworkPacket(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
