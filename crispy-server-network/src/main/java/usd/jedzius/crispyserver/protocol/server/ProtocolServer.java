package usd.jedzius.crispyserver.protocol.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import usd.jedzius.crispyserver.handler.NetworkHandler;
import usd.jedzius.crispyserver.handler.NetworkHandlerException;
import usd.jedzius.crispyserver.handler.NetworkHandlerExtension;
import usd.jedzius.crispyserver.server.NetworkServer;

import java.io.IOException;

public class ProtocolServer implements NetworkServer, NetworkHandlerExtension {
    private Server kryoServer;
    private final int tcp;
    private final int udp;

    private Class<?> handlerClass;

    public ProtocolServer(int tcp, int udp) {
        this.tcp = tcp;
        this.udp = udp;
    }

    @Override
    public void connect() throws IOException {
        this.kryoServer = new Server();
        this.kryoServer.bind(this.getTcp(), this.getUdp());
    }

    @Override
    public void start() {
        this.kryoServer.start();
        this.kryoServer.getKryo().register(byte[].class);
    }

    @Override
    public <T> void bindHandlerClass(Class<?> clazz) {
        this.handlerClass = clazz;
    }

    @Override
    public <T> NetworkServer bindHandler(T handler) throws NetworkHandlerException {
        if(!this.handlerClass.isAssignableFrom(handler.getClass())) {
            throw new NetworkHandlerException("Cannot bind this handler because binded is other handler class!", handler.getClass());
        }

        this.kryoServer.addListener((Listener) handler);
        return this;
    }

    public int getTcp() {
        return tcp;
    }

    public int getUdp() {
        return udp;
    }
}
