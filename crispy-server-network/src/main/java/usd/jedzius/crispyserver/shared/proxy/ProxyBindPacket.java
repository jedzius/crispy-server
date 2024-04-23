package usd.jedzius.crispyserver.shared.proxy;

import usd.jedzius.crispyserver.protocol.packet.ProtocolPacket;

public class ProxyBindPacket extends ProtocolPacket {
    private final String proxyName;

    public ProxyBindPacket(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getProxyName() {
        return proxyName;
    }
}
