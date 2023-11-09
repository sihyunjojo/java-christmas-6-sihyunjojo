package christmas.exception;

import static christmas.message.ErrorMessage.*;

public class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException() {
        super(INVALID_DATE.getMessage());
    }

    public InvalidDateException(String s) {
        super(s);
    }

    public InvalidDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDateException(Throwable cause) {
        super(INVALID_DATE.getMessage(),cause);
    }
}
