package usd.jedzius.crispyserver.server;

public class PlatformServer {
    private final String serverName;
    private int maxPlayers;
    private boolean whitelist;

    public PlatformServer(String serverName) {
        this.serverName = serverName;
        this.maxPlayers = 100;
        this.whitelist = false;
    }

    public String getServerName() {
        return serverName;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public boolean isWhitelist() {
        return whitelist;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setWhitelist(boolean whitelist) {
        this.whitelist = whitelist;
    }
}
