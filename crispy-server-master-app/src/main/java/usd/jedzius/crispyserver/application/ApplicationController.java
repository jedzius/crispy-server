package usd.jedzius.crispyserver.application;

import usd.jedzius.crispyserver.application.user.MasterUserService;
import usd.jedzius.crispyserver.protocol.server.ProtocolServer;

import java.io.IOException;

public class ApplicationController {
    private final ProtocolServer networkServer;
    private final MasterUserService masterUserService;

    public ApplicationController() throws IOException {
        System.out.println("ELO");

        this.networkServer = new ProtocolServer(10000, 10001);
        this.networkServer.connect();
        this.networkServer.start();

        this.masterUserService = new MasterUserService();
    }
}
