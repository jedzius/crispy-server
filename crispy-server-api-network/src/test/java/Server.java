import usd.jedzius.crispyserver.*;

import java.util.ArrayList;
import java.util.List;


public class Server implements NetworkServer, NetworkHandlerExtension {

    private final List<NetworkHandler<?>> handlerList = new ArrayList<>();
    private Class<?> networkHandlerClass;

    @Override
    public void connect() {

    }

    @Override
    public void start() {

    }


    @Override
    public <T> void bindHandlerClass(Class<?> clazz) {
        this.networkHandlerClass = clazz;
        System.out.println("binded new handler class " + clazz.getSimpleName());
    }

    @Override
    public <T> NetworkServer bindHandler(T handler) throws NetworkHandlerException {
        if(!networkHandlerClass.isAssignableFrom(handler.getClass())) {
            throw new NetworkHandlerException("This class doesn't implement binded handler class!", handler.getClass());
        }

        System.out.println("added new handler");
        this.handlerList.add((NetworkHandler<?>) handler);

        return this;
    }
}
