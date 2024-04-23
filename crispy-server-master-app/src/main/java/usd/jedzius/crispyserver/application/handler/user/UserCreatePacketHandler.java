package usd.jedzius.crispyserver.application.handler.user;

import usd.jedzius.crispyserver.application.user.MasterPlatformUser;
import usd.jedzius.crispyserver.application.user.MasterPlatformUserService;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.user.UserCreatePacket;

public class UserCreatePacketHandler extends ProtocolPacketHandler<UserCreatePacket> {

    private final MasterPlatformUserService masterPlatformUserService;

    public UserCreatePacketHandler(MasterPlatformUserService masterPlatformUserService) {
        super(UserCreatePacket.class);
        this.masterPlatformUserService = masterPlatformUserService;
    }

    @Override
    public void execute(UserCreatePacket packet) {
        this.masterPlatformUserService.put(packet.getUniqueId(), new MasterPlatformUser(packet.getUniqueId()));
        System.out.println("new user");
    }
}
