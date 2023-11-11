package christmas.global;

public enum EventBadge {
    no("없음",0),
    star("별", 5000),
    tree("트리", 10000),
    santa("산타", 20000);

    private final String name;
    private final int priceCondition;

    EventBadge(String name, int priceCondition) {
        this.name = name;
        this.priceCondition = priceCondition;
    }

    public String getName() {
        return name;
    }

    public int getPriceCondition() {
        return priceCondition;
    }

    public static EventBadge determineEventBadge(int orderPrice) {
        for (EventBadge badge : values()) {
            if (badge.getPriceCondition() <= orderPrice) {
                return badge;
            }
        }
        return no;
    }

}
