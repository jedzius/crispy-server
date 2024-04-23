package usd.jedzius.crispyserver.protocol.packet.handler;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import usd.jedzius.crispyserver.handler.NetworkHandler;
import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public abstract class ProtocolPacketHandler<T extends ProtocolPacket> extends NetworkHandler<ProtocolPacket> implements Listener {

    private final Class<?> packet;

    protected ProtocolPacketHandler(Class<?> packet) {
        this.packet = packet;
    }

    @Override
    public void received(Connection connection, Object object) {
        if(!object.getClass().isAssignableFrom(byte[].class)) return;

        try (ByteArrayInputStream bis = new ByteArrayInputStream((byte[]) object); ObjectInputStream ois = new ObjectInputStream(bis)) {
            var packet = ois.readObject();

            if(packet.getClass().isAssignableFrom(this.packet)) {
                this.execute((T)packet);
            }
        } catch (Exception e) {
            System.out.println("[WARN] Cannot handle this packet!");
        }
    }



    public abstract void execute(T packet);
}
