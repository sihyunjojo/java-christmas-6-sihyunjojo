package christmas.domain;

import static christmas.domain.DDayDisCountPrice.*;

import java.time.LocalDate;

public class DDayDiscount {
    private final DDayDisCountPrice currentDiscountPrice;

    private DDayDiscount(int currentDay) {
        LocalDate currentDate = LocalDate.of(2023, 12, currentDay);
        this.currentDiscountPrice = createDDayDisCountPrice(currentDate);
    }

    public static DDayDiscount createDDayDiscount(int currentDay){
        return new DDayDiscount(currentDay);
    }

    public int getCurrentDiscountPrice() {
        return currentDiscountPrice.getDiscountPrice();
    }
}

