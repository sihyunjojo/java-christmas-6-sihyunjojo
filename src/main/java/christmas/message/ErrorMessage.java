package christmas.message;

public enum ErrorMessage {
    INVALID_DATE("[ERROR] 잘못된 날짜입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
