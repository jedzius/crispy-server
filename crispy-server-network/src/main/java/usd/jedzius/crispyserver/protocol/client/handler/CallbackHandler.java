package usd.jedzius.crispyserver.protocol.client.handler;

import com.esotericsoftware.kryonet.Connection;
import usd.jedzius.crispyserver.protocol.packet.callback.CallbackPacket;
import usd.jedzius.crispyserver.protocol.packet.callback.CallbackService;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;

public class CallbackHandler extends ProtocolPacketHandler<CallbackPacket> {

    private final CallbackService callbackService;

    public CallbackHandler(CallbackService callbackService) {
        super(CallbackPacket.class);
        this.callbackService = callbackService;
    }

    @Override
    public void execute(CallbackPacket packet, Connection connection) {
        this.callbackService.search(packet.getPacketId()).ifPresent(integerConsumer -> integerConsumer.accept(packet.getReplacement()));
        this.callbackService.flush(packet.getPacketId());
    }
}
