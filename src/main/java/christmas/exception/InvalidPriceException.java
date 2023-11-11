package christmas.exception;

public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException() {
        super();
    }

    public InvalidPriceException(String s) {
        super(s);
    }

    public InvalidPriceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPriceException(Throwable cause) {
        super(cause);
    }
}
