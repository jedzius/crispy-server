package usd.jedzius.crispyserver.protocol.server;

import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
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
        System.out.println("[INFO] Bound " + clazz.getSimpleName() + " as default handler class.");
    }

    @Override
    public <T> void bindHandler(T handler) throws NetworkHandlerException {
        if(!this.handlerClass.isAssignableFrom(handler.getClass())) {
            throw new NetworkHandlerException("Cannot bind this handler because bound is other handler class!", handler.getClass());
        }

        this.kryoServer.addListener((Listener) handler);
        System.out.println("[INFO] Registered new handler " + handler.getClass().getSimpleName());
    }

    public int getTcp() {
        return tcp;
    }

    public int getUdp() {
        return udp;
    }
}
