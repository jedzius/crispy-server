package usd.jedzius.crispyserver.application.handler.user;

import com.esotericsoftware.kryonet.Connection;
import usd.jedzius.crispyserver.application.user.MasterPlatformUser;
import usd.jedzius.crispyserver.application.user.MasterPlatformUserService;
import usd.jedzius.crispyserver.protocol.packet.callback.CallbackPacket;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.user.UserCreatePacket;

public class UserCreatePacketHandler extends ProtocolPacketHandler<UserCreatePacket> {

    private final MasterPlatformUserService masterPlatformUserService;

    public UserCreatePacketHandler(MasterPlatformUserService masterPlatformUserService) {
        super(UserCreatePacket.class);
        this.masterPlatformUserService = masterPlatformUserService;
    }

    @Override
    public void execute(UserCreatePacket packet, Connection connection) {
        var user = new MasterPlatformUser(packet.getUniqueId());
        user.setConnectedProxy(packet.getProxyName());
        this.masterPlatformUserService.put(packet.getUniqueId(), user);
        System.out.println("new user");

        this.applyCallback(connection, packet, user.getUniqueId());
    }
}
