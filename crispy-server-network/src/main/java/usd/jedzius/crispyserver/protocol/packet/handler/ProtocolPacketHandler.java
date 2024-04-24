package usd.jedzius.crispyserver.protocol.packet.handler;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import usd.jedzius.crispyserver.handler.NetworkHandler;
import usd.jedzius.crispyserver.packet.NetworkPacket;
import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;
import usd.jedzius.crispyserver.packet.callback.Callback;
import usd.jedzius.crispyserver.protocol.packet.callback.CallbackPacket;
import usd.jedzius.crispyserver.protocol.packet.encoder.ProtocolPacketEncoder;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public abstract class ProtocolPacketHandler<T extends ProtocolPacket> extends NetworkHandler<ProtocolPacket> implements Listener {

    public final static ProtocolPacketEncoder PACKET_ENCODER = new ProtocolPacketEncoder();
    private final Class<?> packet;

    protected ProtocolPacketHandler(Class<?> packet) {
        this.packet = packet;
    }

    @Override
    public void received(Connection connection, Object object) {
        if(!object.getClass().isAssignableFrom(byte[].class)) return;

        var packet = PACKET_ENCODER.decode((byte[]) object);

        if(packet.getClass().isAssignableFrom(this.packet)) {
            this.execute((T)packet, connection);
        }
    }

    public void applyCallback(Connection connection, NetworkPacket packet, Object replacement) {
        if (Callback.class.isAssignableFrom(packet.getClass())) {
            System.out.println("with callback");
            // send callback packet
            connection.sendTCP(PACKET_ENCODER.encode(new CallbackPacket(packet.getId(), replacement)));
        }
    }


    public abstract void execute(T packet, Connection connection);
}
