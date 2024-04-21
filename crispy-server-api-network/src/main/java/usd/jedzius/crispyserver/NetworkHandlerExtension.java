package usd.jedzius.crispyserver;

public interface NetworkHandlerExtension {
    <T> void bindHandlerClass(Class<?> clazz);
    <T> NetworkServer bindHandler(T handler) throws NetworkHandlerException;
}
