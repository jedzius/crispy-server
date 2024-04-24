package usd.jedzius.crispyserver.protocol.client.handler;

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
    public void execute(CallbackPacket packet) {
        this.callbackService.search(packet.getPacketId())
                .ifPresent(integerConsumer -> integerConsumer.accept(1));
        this.callbackService.flush(packet.getPacketId());
    }
}
