package usd.jedzius.crispyserver.proxy;

public class PlatformProxy {
    private final String proxyName;
    private int online;

    public PlatformProxy(String proxyName) {
        this.proxyName = proxyName;
        this.online = 0;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getProxyName() {
        return proxyName;
    }
}
