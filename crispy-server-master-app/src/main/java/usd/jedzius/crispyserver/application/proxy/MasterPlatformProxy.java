package usd.jedzius.crispyserver.application.proxy;

import usd.jedzius.crispyserver.application.user.MasterPlatformUser;
import usd.jedzius.crispyserver.proxy.PlatformProxy;

import java.util.ArrayList;
import java.util.List;

public class MasterPlatformProxy extends PlatformProxy {

    private final List<MasterPlatformUser> connectedPlayers;

    public MasterPlatformProxy(String proxyName) {
        super(proxyName);
        this.connectedPlayers = new ArrayList<>();
    }

    public void add(final MasterPlatformUser user) {
        this.connectedPlayers.add(user);
    }

    public void flush(final MasterPlatformUser user) {
        this.connectedPlayers.remove(user);
    }

    public List<MasterPlatformUser> getConnectedPlayers() {
        return connectedPlayers;
    }
}
