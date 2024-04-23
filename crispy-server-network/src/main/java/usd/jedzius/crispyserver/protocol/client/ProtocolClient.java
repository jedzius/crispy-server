package usd.jedzius.crispyserver.protocol.client;

import com.esotericsoftware.kryonet.Client;
import usd.jedzius.crispyserver.client.NetworkClient;
import usd.jedzius.crispyserver.packet.NetworkPacket;

import java.io.*;

public class ProtocolClient implements NetworkClient {

    private Client networkClient;
    private final int tcp;
    private final int udp;

    public ProtocolClient(int tcp, int udp) {
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
    }

    @Override
    public void close() {

    }

    @Override
    public void send(NetworkPacket packet) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(packet);
            this.networkClient.sendTCP(bos.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getUdp() {
        return udp;
    }

    public int getTcp() {
        return tcp;
    }
}
