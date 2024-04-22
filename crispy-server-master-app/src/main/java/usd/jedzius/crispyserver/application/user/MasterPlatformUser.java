package usd.jedzius.crispyserver.application.user;

import usd.jedzius.crispyserver.user.PlatformUser;

import java.util.UUID;

public class MasterPlatformUser extends PlatformUser {

    private String connectedServer;

    public MasterPlatformUser(UUID uniqueId) {
        super(uniqueId);
        this.connectedServer = "";
    }

    public void setConnectedServer(String connectedServer) {
        this.connectedServer = connectedServer;
    }

    public String getConnectedServer() {
        return connectedServer;
    }
}
