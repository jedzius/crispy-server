package usd.jedzius.crispyserver.application.handler.user;

import com.esotericsoftware.kryonet.Connection;
import usd.jedzius.crispyserver.application.user.MasterPlatformUserService;
import usd.jedzius.crispyserver.protocol.packet.handler.ProtocolPacketHandler;
import usd.jedzius.crispyserver.shared.user.UserProxyCommandPacket;

public class UserProxyCommandPacketHandler extends ProtocolPacketHandler<UserProxyCommandPacket> {
    private final MasterPlatformUserService masterPlatformUserService;
    public UserProxyCommandPacketHandler(MasterPlatformUserService masterPlatformUserService) {
        super(UserProxyCommandPacket.class);
        this.masterPlatformUserService = masterPlatformUserService;
    }

    @Override
    public void execute(UserProxyCommandPacket packet, Connection connection) {
        this.masterPlatformUserService.search(packet.getUniqueId()).ifPresent(masterPlatformUser -> {
            final var data = new StringBuilder();
            data
                    .append(masterPlatformUser.getUniqueId())
                    .append(":")
                    .append(masterPlatformUser.getConnectedProxy());

            this.applyCallback(connection, packet, data.toString());
        });
    }
}
