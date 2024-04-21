import usd.jedzius.crispyserver.NetworkHandler;
import usd.jedzius.crispyserver.NetworkHandlerException;
import usd.jedzius.crispyserver.NetworkPacket;

public class Main {

    public static void main(String[] args) throws NetworkHandlerException {
        foo();
    }

    static void foo() throws NetworkHandlerException {
        var server = new Server();
        server.connect();
        server.start();
        server.bindHandlerClass(ServerHandler.class);
        server.bindHandler(new TestHandler());
        server.bindHandler(new TestHandlerNonValid());
    }


    public static class TestHandlerNonValid {

    }

    public static class TestHandler extends ServerHandler {
        @Override
        public void execute(ServerPacket packet) {
            System.out.println(packet.uid);
        }
    }

    public record ServerPacket(long uid) implements NetworkPacket {
    }

    public static abstract class ServerHandler extends NetworkHandler<ServerPacket> {

        @Override
        public void handle(ServerPacket packet) {
            this.execute(packet);
        }

        public abstract void execute(ServerPacket packet);
    }
}
