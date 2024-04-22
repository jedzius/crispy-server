package usd.jedzius.crispyserver.application;

import usd.jedzius.crispyserver.application.handler.user.UserCreatePacketHandler;
import usd.jedzius.crispyserver.application.user.MasterUserService;
import usd.jedzius.crispyserver.handler.NetworkHandlerException;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.protocol.server.ProtocolServer;

import java.io.IOException;

public class ApplicationController {
    private final MasterUserService masterUserService;

    public ApplicationController() throws IOException, NetworkHandlerException {
        var networkServer = new ProtocolServer(10000, 10001);

        networkServer.connect();
        networkServer.start();
        networkServer.bindHandlerClass(ProtocolPacketHandler.class);
        networkServer.bindHandler(new UserCreatePacketHandler());

        this.masterUserService = new MasterUserService();
    }

    public MasterUserService getMasterUserService() {
        return masterUserService;
    }
}
