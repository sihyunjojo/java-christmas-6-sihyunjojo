package christmas.domain.event.discount;

import static christmas.domain.DDayDisCountPrice.*;

import christmas.domain.DDayDisCountPrice;
import christmas.validator.DateValidator;
import java.time.LocalDate;
import java.util.Objects;

public class DDayDiscount {
    private final DDayDisCountPrice currentDiscountPrice;

    public DDayDiscount(LocalDate currentDate) {
        this.currentDiscountPrice = createDDayDisCountPrice(currentDate);
    }


    public static DDayDiscount createDDayDiscount(LocalDate currentDate){
        DateValidator.validateDDayDisCountPeriod(currentDate);

        return new DDayDiscount(currentDate);
    }

    public int discountOrderPrice(int orderPrice) {
        return orderPrice - getCurrentDiscountPrice();
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

