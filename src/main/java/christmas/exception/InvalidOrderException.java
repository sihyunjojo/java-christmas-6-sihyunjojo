package christmas.exception;

import static christmas.message.ErrorMessage.INVALID_ORDER;

public class InvalidOrderException extends IllegalArgumentException {
    public InvalidOrderException() {
        super(INVALID_ORDER.getMessage());
    }

}
