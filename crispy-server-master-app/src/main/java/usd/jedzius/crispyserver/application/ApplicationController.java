package usd.jedzius.crispyserver.application;

import usd.jedzius.crispyserver.application.handler.proxy.ProxyBindPacketHandler;
import usd.jedzius.crispyserver.application.handler.proxy.ProxyUnBindPacketHandler;
import usd.jedzius.crispyserver.application.handler.server.ServerBindPacketHandler;
import usd.jedzius.crispyserver.application.handler.server.ServerUnBindPacketHandler;
import usd.jedzius.crispyserver.application.handler.user.UserCreatePacketHandler;
import usd.jedzius.crispyserver.application.handler.user.UserFlushPacketHandler;
import usd.jedzius.crispyserver.application.proxy.MasterPlatformProxy;
import usd.jedzius.crispyserver.application.proxy.MasterPlatformProxyService;
import usd.jedzius.crispyserver.application.server.MasterPlatformServer;
import usd.jedzius.crispyserver.application.server.MasterPlatformServerService;
import usd.jedzius.crispyserver.application.user.MasterPlatformUserService;
import usd.jedzius.crispyserver.handler.NetworkHandlerException;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.protocol.server.ProtocolServer;

import java.io.IOException;

public class ApplicationController {
    private final MasterPlatformUserService masterPlatformUserService;
    private final MasterPlatformServerService masterPlatformServerService;
    private final MasterPlatformProxyService masterPlatformProxyService;

    public ApplicationController() throws IOException, NetworkHandlerException {
        var networkServer = new ProtocolServer(10000, 10001);

        this.masterPlatformUserService = new MasterPlatformUserService();
        this.masterPlatformServerService = new MasterPlatformServerService();
        this.masterPlatformProxyService = new MasterPlatformProxyService();

        this.masterPlatformProxyService.put("PROXY_1", new MasterPlatformProxy("PROXY_1"));

        this.masterPlatformServerService.put("SERVER_1", new MasterPlatformServer("LOBBY_1"));
        this.masterPlatformServerService.put("SURVIVAL_1", new MasterPlatformServer("SURVIVAL_1"));

        networkServer.connect();
        networkServer.start();
        networkServer.bindHandlerClass(ProtocolPacketHandler.class);

        networkServer.bindHandler(new UserCreatePacketHandler(this.masterPlatformUserService));
        networkServer.bindHandler(new UserFlushPacketHandler(this.masterPlatformUserService));

        networkServer.bindHandler(new ServerBindPacketHandler(this.masterPlatformServerService));
        networkServer.bindHandler(new ServerUnBindPacketHandler(this.masterPlatformServerService));

        networkServer.bindHandler(new ProxyBindPacketHandler(this.masterPlatformProxyService));
        networkServer.bindHandler(new ProxyUnBindPacketHandler(this.masterPlatformProxyService));
    }
}
