package christmas.domain.event.discount;

import static christmas.global.BenefitDetail.SPECIAL_DISCOUNT;
import static christmas.global.constants.DisCountPriceConstants.SPECIAL_DISCOUNT_PRICE;

import christmas.domain.Benefit;
import java.util.Objects;

public class SpecialDiscount extends Benefit {
    private final int allDisCountPrice;


    public SpecialDiscount() {
        this.allDisCountPrice = SPECIAL_DISCOUNT_PRICE;
    }

    public static SpecialDiscount createSpecialDiscount() {
        return new SpecialDiscount();
    }
    @Override
    public String getName() {
        return SPECIAL_DISCOUNT.getName();
    }

    @Override
    public int getBenefitPrice() {
        return allDisCountPrice;
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
        return allDisCountPrice == that.allDisCountPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(allDisCountPrice);
    }
}
