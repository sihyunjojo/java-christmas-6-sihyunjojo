package christmas.domain.event.discount;

import static christmas.global.DisCountPriceConstants.SPECIAL_DISCOUNT_PRICE;

public class SpecialDiscount {

    private final int discountPrice = SPECIAL_DISCOUNT_PRICE;

    public SpecialDiscount() {
    }

    public static SpecialDiscount createSpecialDiscount() {

        return new SpecialDiscount();
    }

    public int discountAllOrderPrice(int orderAllPrice) {
        return orderAllPrice - discountPrice;
    }


}
