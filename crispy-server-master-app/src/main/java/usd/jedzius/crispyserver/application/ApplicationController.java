package usd.jedzius.crispyserver.application;

import usd.jedzius.crispyserver.application.handler.server.ServerBindPacketHandler;
import usd.jedzius.crispyserver.application.handler.server.ServerUnBindPacketHandler;
import usd.jedzius.crispyserver.application.handler.user.UserCreatePacketHandler;
import usd.jedzius.crispyserver.application.proxy.MasterPlatformProxyService;
import usd.jedzius.crispyserver.application.server.MasterPlatformServer;
import usd.jedzius.crispyserver.application.server.MasterPlatformServerService;
import usd.jedzius.crispyserver.application.user.MasterPlatformUserService;
import usd.jedzius.crispyserver.handler.NetworkHandlerException;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.protocol.server.ProtocolServer;

import java.io.IOException;
import java.util.UUID;

public class ApplicationController {
    private final MasterPlatformUserService masterPlatformUserService;
    private final MasterPlatformServerService masterPlatformServerService;
    private final MasterPlatformProxyService masterPlatformProxyService;

    public ApplicationController() throws IOException, NetworkHandlerException {
        var networkServer = new ProtocolServer(10000, 10001);

        this.masterPlatformUserService = new MasterPlatformUserService();
        this.masterPlatformServerService = new MasterPlatformServerService();
        this.masterPlatformProxyService = new MasterPlatformProxyService();

        this.masterPlatformServerService.put("SERVER_1", new MasterPlatformServer("LOBBY_1"));
        this.masterPlatformServerService.put("SURVIVAL_1", new MasterPlatformServer("SURVIVAL_1"));

        networkServer.connect();
        networkServer.start();
        networkServer.bindHandlerClass(ProtocolPacketHandler.class);

        networkServer.bindHandler(new UserCreatePacketHandler());
        networkServer.bindHandler(new ServerBindPacketHandler(this.masterPlatformServerService));
        networkServer.bindHandler(new ServerUnBindPacketHandler(this.masterPlatformServerService));
    }

    public MasterPlatformUserService getMasterUserService() {
        return masterPlatformUserService;
    }

    public MasterPlatformServerService getMasterPlatformServerService() {
        return masterPlatformServerService;
    }
}
