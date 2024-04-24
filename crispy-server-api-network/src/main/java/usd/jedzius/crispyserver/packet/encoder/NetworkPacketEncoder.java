package usd.jedzius.crispyserver.packet.encoder;

import usd.jedzius.crispyserver.packet.NetworkPacket;

public interface NetworkPacketEncoder {
    byte[] encode(NetworkPacket packet);
    NetworkPacket decode(byte[] data);
}
