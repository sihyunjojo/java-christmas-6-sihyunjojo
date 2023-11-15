package christmas.exception;

import static christmas.message.ErrorMessage.*;

public class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException() {
        super(INVALID_DATE.getMessage());
    }
}
