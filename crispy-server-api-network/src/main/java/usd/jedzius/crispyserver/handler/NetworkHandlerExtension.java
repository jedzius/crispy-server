package usd.jedzius.crispyserver.handler;

import usd.jedzius.crispyserver.server.NetworkServer;

public interface NetworkHandlerExtension {
    <T> void bindHandlerClass(Class<?> clazz);
    <T> NetworkServer bindHandler(T handler) throws NetworkHandlerException;
}
