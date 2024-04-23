package usd.jedzius.crispyserver.proxy;

public class PlatformProxy {
    private final String proxyName;

    public PlatformProxy(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getProxyName() {
        return proxyName;
    }
}
