package christmas.exception;

import static christmas.message.ErrorMessage.INVALID_ORDER;

public class InvalidOrderException extends IllegalArgumentException {
    public InvalidOrderException() {
        super(INVALID_ORDER.getMessage());
    }

    public InvalidOrderException(String s) {
        super(s);
    }

    public InvalidOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOrderException(Throwable cause) {
        super(cause);
    }
}
