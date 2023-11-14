package christmas.exception;

import static christmas.message.ErrorMessage.INVALID_PRICE;

public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException() {
        super(INVALID_PRICE.getMessage());
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
