package christmas.exception;

import static christmas.message.ErrorMessage.INVALID_INPUT;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super(INVALID_INPUT.getMessage());
    }

    public InvalidInputException(String s) {
        super(s);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
