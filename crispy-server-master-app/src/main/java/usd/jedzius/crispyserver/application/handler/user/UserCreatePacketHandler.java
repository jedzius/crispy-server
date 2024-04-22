package usd.jedzius.crispyserver.application.handler.user;

import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.user.UserCreatePacket;

public class UserCreatePacketHandler extends ProtocolPacketHandler<UserCreatePacket> {
    public UserCreatePacketHandler() {
        super(UserCreatePacket.class);
    }

    @Override
    public void execute(UserCreatePacket packet) {
        System.out.println(packet.getNickname());
    }
}
