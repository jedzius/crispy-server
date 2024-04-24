package usd.jedzius.crispyserver.application.handler.user;

import com.esotericsoftware.kryonet.Connection;
import usd.jedzius.crispyserver.application.user.MasterPlatformUserService;
import usd.jedzius.crispyserver.protocol.packet.callback.CallbackPacket;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.user.UserProxyInfoPacket;

public class UserProxyInfoPacketHandler extends ProtocolPacketHandler<UserProxyInfoPacket> {
    private final MasterPlatformUserService masterPlatformUserService;
    public UserProxyInfoPacketHandler(MasterPlatformUserService masterPlatformUserService) {
        super(UserProxyInfoPacket.class);
        this.masterPlatformUserService = masterPlatformUserService;
    }

    @Override
    public void execute(UserProxyInfoPacket packet, Connection connection) {
        this.masterPlatformUserService.search(packet.getUniqueId()).ifPresent(masterPlatformUser -> {
            this.applyCallback(connection, packet, masterPlatformUser.getConnectedProxy());
        });
    }
}
