package christmas.exception;

import static christmas.message.ErrorMessage.INVALID_MENU;

public class InvalidMenuException extends IllegalArgumentException {
    public InvalidMenuException() {
        super(INVALID_MENU.getMessage());
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
