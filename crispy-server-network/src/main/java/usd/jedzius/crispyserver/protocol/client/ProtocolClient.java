package usd.jedzius.crispyserver.protocol.client;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Listener;
import usd.jedzius.crispyserver.client.NetworkClient;
import usd.jedzius.crispyserver.handler.NetworkHandlerException;
import usd.jedzius.crispyserver.handler.NetworkHandlerExtension;
import usd.jedzius.crispyserver.packet.NetworkPacket;
import usd.jedzius.crispyserver.packet.callback.Callback;
import usd.jedzius.crispyserver.protocol.client.handler.CallbackHandler;
import usd.jedzius.crispyserver.protocol.packet.callback.CallbackService;
import usd.jedzius.crispyserver.protocol.packet.encoder.ProtocolPacketEncoder;

import java.io.*;

public class ProtocolClient implements NetworkClient, NetworkHandlerExtension {

    private final static ProtocolPacketEncoder PACKET_ENCODER = new ProtocolPacketEncoder();

    private final CallbackService callbackService;

    private Client networkClient;
    private final int tcp;
    private final int udp;

    private Class<?> handlerClass;

    public ProtocolClient(int tcp, int udp) {
        this.callbackService = new CallbackService();
        this.tcp = tcp;
        this.udp = udp;
    }

    @Override
    public void connect() throws IOException {
        this.networkClient.connect(10000, "localhost", this.getTcp(), this.getUdp());
    }

    @Override
    public void start() {
        this.networkClient = new Client();
        this.networkClient.start();

        this.networkClient.getKryo().register(byte[].class);
        this.networkClient.addListener(new CallbackHandler(this.callbackService));
    }

    @Override
    public void close() {

    }

    @Override
    public void send(NetworkPacket packet) {
        var data = PACKET_ENCODER.encode(packet);

        if(Callback.class.isAssignableFrom(packet.getClass())) {
            System.out.println("has callback interface");
            this.callbackService.put(packet);
        }
        this.networkClient.sendTCP(data);
    }

    public int getUdp() {
        return udp;
    }

    public int getTcp() {
        return tcp;
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

        this.networkClient.addListener((Listener) handler);
        System.out.println("[INFO] Registered new handler " + handler.getClass().getSimpleName());
    }
}
