package christmas.domain.event.discount;

import static christmas.domain.DDayDisCountPrice.*;
import static christmas.global.BenefitDetail.*;

import christmas.domain.Benefit;
import christmas.domain.DDayDisCountPrice;
import java.time.LocalDate;
import java.util.Objects;

public class DDayDiscount extends Benefit {
    private final DDayDisCountPrice discountPrice;
    private final int allDisCountPrice;

    public DDayDiscount(LocalDate date) {
        this.discountPrice = createDDayDisCountPrice(date);
        this.allDisCountPrice = getDiscountPrice();
    }

    public static DDayDiscount createDDayDiscount(LocalDate date){

        return new DDayDiscount(date);
    }

    public int getDiscountPrice() {
        return discountPrice.discountPrice();
    }

    @Override
    public String getName() {
        return D_DAY_DISCOUNT.getName();
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
        DDayDiscount that = (DDayDiscount) o;
        return allDisCountPrice == that.allDisCountPrice && Objects.equals(discountPrice, that.discountPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountPrice, allDisCountPrice);
    }
}

