package usd.jedzius.crispyserver.application.handler.user;

import usd.jedzius.crispyserver.application.user.MasterPlatformUserService;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.user.UserFlushPacket;

public class UserFlushPacketHandler extends ProtocolPacketHandler<UserFlushPacket> {

    private final MasterPlatformUserService masterPlatformUserService;

    public UserFlushPacketHandler(MasterPlatformUserService masterPlatformUserService) {
        super(UserFlushPacket.class);
        this.masterPlatformUserService = masterPlatformUserService;
    }

    @Override
    public void execute(UserFlushPacket packet) {
        this.masterPlatformUserService.flush(packet.getUniqueId());
        System.out.println("flush user");
    }
}
