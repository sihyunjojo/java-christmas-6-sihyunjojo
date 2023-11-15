package christmas.exception;

import static christmas.message.ErrorMessage.INVALID_INPUT;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super(INVALID_INPUT.getMessage());
    }
}
