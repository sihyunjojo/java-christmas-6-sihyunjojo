package christmas.domain.event;

import static christmas.global.FoodMenu.*;

import christmas.global.FoodMenu;

public class GiveawayEvent {
    // GiveawayProduct라는 객체 만들어서 메뉴와 개수 관리하면 좋을거 같다.
    private final FoodMenu GiveawayProduct = CHAMPAGNE;

    public GiveawayEvent() {
    }

    public static GiveawayEvent createGiveawayEvent() {
        return new GiveawayEvent();
    }

    public int getGiveawayProductPrice() {
        return GiveawayProduct.getPrice();
    }
    public String getGiveawayProductName() {
        return GiveawayProduct.getName();
    }
}
