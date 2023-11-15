package christmas.message;

public enum SystemMessage implements MessageProvider{

    HELLO_EVENT_PLANNER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INPUT_DAY("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_FOOD_MENUS("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    INPUT_BENEFIT_INFORMATION("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_ORDER_MENU("<주문 메뉴>"),
    OUTPUT_TOTAL_ORDER_PRICE_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    OUTPUT_GIVE_AWAY_MENU("<증정 메뉴>"),
    OUTPUT_BENEFIT_DETAIL("<혜택 내역>"),
    OUTPUT_TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    OUTPUT_PAYMENT_PRICE_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    OUTPUT_DECEMBER_EVENT_BADGE("<12월 이벤트 배지>"),
    OUTPUT_NOTHING("없음"),
    OUTPUT_PRICE_MESSAGE("%,d원"),
    OUTPUT_MENU_NAME_AND_COUNT_MESSAGE("%s %d개"),
    OUTPUT_BENEFIT_MESSAGE("%s: -%,d원"),
    OUTPUT_MINUS_PRICE_MESSAGE("-%,d원");


    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
