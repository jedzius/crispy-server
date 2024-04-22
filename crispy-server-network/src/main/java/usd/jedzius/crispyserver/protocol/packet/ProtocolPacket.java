package usd.jedzius.crispyserver.protocol.packet;

import usd.jedzius.crispyserver.packet.NetworkPacket;

import java.util.concurrent.ThreadLocalRandom;

public class ProtocolPacket extends NetworkPacket {
    public ProtocolPacket() {
        super(ThreadLocalRandom.current().nextLong());
    }
}
