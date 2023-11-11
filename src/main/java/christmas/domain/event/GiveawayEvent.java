package christmas.domain.event;

import static christmas.global.constants.EventValidateConstants.GIVE_AWAY_PRODUCT_PRICE_CONDITION;
import static christmas.global.FoodMenu.*;

import christmas.domain.Order;
import christmas.global.FoodMenu;
import christmas.validator.DateValidator;
import java.time.LocalDate;

public class GiveAwayEvent {
    // GiveawayProduct라는 객체 만들어서 메뉴와 개수 관리하면 좋을거 같다.
    private final FoodMenu giveAwayProduct = CHAMPAGNE;

    public GiveAwayEvent() {
    }

    public static GiveAwayEvent createGiveawayEvent(Order order, LocalDate date) {
        DateValidator.validateDisCountPeriod(date);
        if (GIVE_AWAY_PRODUCT_PRICE_CONDITION <= order.getOrderAllPrice()) {
            return new GiveAwayEvent();
        }
        return null;
    }

    public FoodMenu getGiveawayProduct() {
        return giveAwayProduct;
    }

    public int getGiveawayProductPrice() {
        return giveAwayProduct.getPrice();
    }
    public String getGiveawayProductName() {
        return giveAwayProduct.getName();
    }
}
