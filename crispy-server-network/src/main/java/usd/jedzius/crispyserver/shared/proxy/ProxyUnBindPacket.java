package usd.jedzius.crispyserver.shared.proxy;

import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

public class ProxyUnBindPacket extends ProtocolPacket {
    private final String proxyName;

    public ProxyUnBindPacket(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getProxyName() {
        return proxyName;
    }
}
