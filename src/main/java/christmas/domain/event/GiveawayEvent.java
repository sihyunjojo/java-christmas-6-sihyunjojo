package christmas.domain.event;

import static christmas.global.constants.EventValidateConstants.GIVE_AWAY_PRODUCT_PRICE_CONDITION;
import static christmas.global.FoodMenu.*;

import christmas.domain.GiveAwayProduct;
import christmas.domain.Order;
import christmas.validator.DateValidator;
import java.time.LocalDate;

public class GiveAwayEvent {
    private final GiveAwayProduct giveAwayProduct;

    public GiveAwayEvent() {
        this.giveAwayProduct = GiveAwayProduct.createGiveAwayProduct(CHAMPAGNE, 1);
    }

    public static GiveAwayEvent createGiveawayEvent(Order order, LocalDate date) {
        DateValidator.validateDisCountPeriod(date);
        if (GIVE_AWAY_PRODUCT_PRICE_CONDITION <= order.getOrderAllPrice()) {
            return new GiveAwayEvent();
        }
        return null;
    }

    public int getGiveawayProductPrice() {
        return giveAwayProduct.product().getPrice();
    }
    public String getGiveawayProductName() {
        return giveAwayProduct.product().getName();
    }

    public int getGiveawayProductCount(){
        return giveAwayProduct.count();
    }
}
