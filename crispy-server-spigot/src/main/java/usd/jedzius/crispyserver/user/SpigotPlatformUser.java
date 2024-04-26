package usd.jedzius.crispyserver.user;

import java.util.UUID;

public class SpigotPlatformUser extends PlatformUser {

    private String proxy;
    private String server;

    public SpigotPlatformUser(UUID uniqueId) {
        super(uniqueId);
        this.proxy = "";
        this.server = "";
    }

    public String getProxy() {
        return proxy;
    }

    public String getServer() {
        return server;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
