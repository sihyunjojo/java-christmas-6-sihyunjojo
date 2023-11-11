package christmas.domain.event.discount;

import static christmas.global.constants.DisCountPriceConstants.SPECIAL_DISCOUNT_PRICE;

import christmas.validator.DateValidator;
import java.time.LocalDate;

public class SpecialDiscount {

    private final int discountPrice = SPECIAL_DISCOUNT_PRICE;

    public SpecialDiscount() {
    }

    public static SpecialDiscount createSpecialDiscount(LocalDate date) {
        DateValidator.validateSpecialDisCountPeriod(date);
        return new SpecialDiscount();
    }

    public int discountAllOrderPrice(int orderAllPrice) {
        return orderAllPrice - discountPrice;
    }


}
