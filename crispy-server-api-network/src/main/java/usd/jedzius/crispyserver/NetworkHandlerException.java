package usd.jedzius.crispyserver;

public class NetworkHandlerException extends Exception {
    private String message;
    private Class<?> clazz;

    public NetworkHandlerException(String message, Class<?> clazz) {
        this.message = message;
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
