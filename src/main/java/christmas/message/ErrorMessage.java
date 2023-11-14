package christmas.message;

public enum ErrorMessage implements MessageProvider{
    INVALID_DATE("[ERROR] 잘못된 날짜입니다."),
    INVALID_PRICE("[ERROR] 잘못된 가격입니다."),
    INVALID_MENU("[ERROR] 잘못된 메뉴입니다."),
    INVALID_INPUT("[ERROR] 잘못된 입력입니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
