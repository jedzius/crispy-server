package usd.jedzius.crispyserver.user;

import java.util.UUID;

public class PlatformUser {
    private final UUID uniqueId;

    public PlatformUser(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }
}
