package usd.jedzius.crispyserver.handler;

public interface NetworkHandlerExtension {
    <T> void bindHandlerClass(Class<?> clazz);
    <T> void bindHandler(T handler) throws NetworkHandlerException;
}
