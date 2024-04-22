package usd.jedzius.crispyserver.boostrap;

import usd.jedzius.crispyserver.application.ApplicationController;
import usd.jedzius.crispyserver.handler.NetworkHandlerException;

import java.io.IOException;

public class ApplicationBoostrap {
    public static void main(String[] args) throws IOException, NetworkHandlerException {
        new ApplicationController();
    }
}
