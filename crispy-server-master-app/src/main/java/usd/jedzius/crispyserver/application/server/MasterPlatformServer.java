package usd.jedzius.crispyserver.application.server;

import usd.jedzius.crispyserver.application.user.MasterPlatformUser;
import usd.jedzius.crispyserver.server.PlatformServer;

import java.util.ArrayList;
import java.util.List;

public class MasterPlatformServer extends PlatformServer {

    private final List<MasterPlatformUser> connectedPlayers;
    private boolean enabled;

    public MasterPlatformServer(String serverName) {
        super(serverName);
        this.enabled = false;
        this.connectedPlayers = new ArrayList<>();
    }

    public void add(final MasterPlatformUser user) {
        this.connectedPlayers.add(user);
    }

    public void flush(final MasterPlatformUser user) {
        this.connectedPlayers.remove(user);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<MasterPlatformUser> getConnectedPlayers() {
        return connectedPlayers;
    }
}
