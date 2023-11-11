package christmas.domain;

import static christmas.domain.DDayDisCountPrice.*;
import static christmas.global.DiscountDateConstants.*;

import christmas.validator.DateValidator;
import java.time.LocalDate;
import java.util.Objects;

public class DDayDiscount {
    private final DDayDisCountPrice currentDiscountPrice;

    public DDayDiscount(LocalDate currentDate) {
        this.currentDiscountPrice = createDDayDisCountPrice(currentDate);
    }


    public static DDayDiscount createDDayDiscount(int currentDay){
        LocalDate currentDate = LocalDate.of(DISCOUNT_EVENT_YEAR, DISCOUNT_EVENT_MONTH, currentDay);
        DateValidator.validateDDayDisCountPeriod(currentDate);

        return new DDayDiscount(currentDate);
    }

    public int discountAllOrderPrice(int allOrderPrice) {
        return allOrderPrice - getCurrentDiscountPrice();
    }

    public int getCurrentDiscountPrice() {
        return currentDiscountPrice.discountPrice();
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
        return Objects.equals(currentDiscountPrice, that.currentDiscountPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentDiscountPrice);
    }
}

