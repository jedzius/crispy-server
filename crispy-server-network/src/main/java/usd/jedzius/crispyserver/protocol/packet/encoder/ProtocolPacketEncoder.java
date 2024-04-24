package usd.jedzius.crispyserver.protocol.packet.encoder;

import usd.jedzius.crispyserver.packet.NetworkPacket;
import usd.jedzius.crispyserver.packet.encoder.NetworkPacketEncoder;

import java.io.*;

public class ProtocolPacketEncoder implements NetworkPacketEncoder {

    @Override
    public byte[] encode(NetworkPacket packet) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(packet);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NetworkPacket decode(byte[] data) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream((byte[]) data); ObjectInputStream ois = new ObjectInputStream(bis)) {
            var packet = ois.readObject();
            return (NetworkPacket) packet;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
