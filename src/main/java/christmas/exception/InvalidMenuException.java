package christmas.exception;

public class InvalidMenuException extends IllegalArgumentException {
    public InvalidMenuException() {
        super();
    }

    public InvalidMenuException(String s) {
        super(s);
    }

    public InvalidMenuException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMenuException(Throwable cause) {
        super(cause);
    }
}
