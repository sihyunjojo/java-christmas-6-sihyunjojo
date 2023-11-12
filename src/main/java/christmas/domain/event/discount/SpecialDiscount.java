package christmas.domain.event.discount;

import static christmas.global.constants.DisCountPriceConstants.SPECIAL_DISCOUNT_PRICE;

import christmas.validator.DateValidator;
import java.time.LocalDate;
import java.util.Objects;

public class SpecialDiscount {
    private final int discountPrice = SPECIAL_DISCOUNT_PRICE;

    public SpecialDiscount() {
    }

    public static SpecialDiscount createSpecialDiscount(LocalDate date) {
        DateValidator.validateSpecialDisCountPeriod(date);
        return new SpecialDiscount();
    }

    public int discountAllOrderPrice(int orderPrice) {
        return orderPrice - discountPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpecialDiscount that = (SpecialDiscount) o;
        return discountPrice == that.discountPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountPrice);
    }
}
