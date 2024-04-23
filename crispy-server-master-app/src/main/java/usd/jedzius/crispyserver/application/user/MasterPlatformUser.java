package usd.jedzius.crispyserver.application.user;

import usd.jedzius.crispyserver.application.proxy.MasterPlatformProxy;
import usd.jedzius.crispyserver.user.PlatformUser;

import java.util.UUID;

public class MasterPlatformUser extends PlatformUser {

    private String connectedServer;
    private String connectedProxy;

    public MasterPlatformUser(UUID uniqueId) {
        super(uniqueId);
        this.connectedServer = "";
        this.connectedProxy = "";
    }

    public void setConnectedServer(String connectedServer) {
        this.connectedServer = connectedServer;
    }

    public String getConnectedProxy() {
        return connectedProxy;
    }

    public void setConnectedProxy(String connectedProxy) {
        this.connectedProxy = connectedProxy;
    }

    public String getConnectedServer() {
        return connectedServer;
    }
}
