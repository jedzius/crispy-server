package usd.jedzius.crispyserver.protocol.packet.handler;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import usd.jedzius.crispyserver.handler.NetworkHandler;
import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

public abstract class ProtocolPacketHandler<T extends ProtocolPacket> extends NetworkHandler<ProtocolPacket> implements Listener {

    private final Class<?> packet;

    protected ProtocolPacketHandler(Class<?> packet) {
        this.packet = packet;
    }

    @Override
    public void handle(ProtocolPacket packet) {
//        if(!packet.getClass().isAssignableFrom(this.packet.getClass())) return;
//
//        this.execute(packet);
    }

    @Override
    public void received(Connection connection, Object object) {
        if(!object.getClass().isAssignableFrom(this.packet)) return;

        this.execute((T) object);
    }

    public abstract void execute(T packet);
}
