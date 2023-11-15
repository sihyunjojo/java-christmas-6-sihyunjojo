package christmas.domain;

import static christmas.global.constants.DisCountPriceConstants.*;
import static christmas.global.constants.DiscountDateConstants.*;

import christmas.validator.InputDateValidator;
import java.time.LocalDate;

public record DDayDisCountPrice(int discountPrice) {

    public static DDayDisCountPrice createDDayDisCountPrice(LocalDate currentDate) {
        return new DDayDisCountPrice(updateDDayDisCountPrice(currentDate));
    }

    public static int updateDDayDisCountPrice(LocalDate currentDate) {
        int plusDay = currentDate.getDayOfMonth() - D_DAY_DISCOUNT_START_DAY.getDayOfMonth();

        return INITIAL_D_DAY_DISCOUNT_PRICE
                + (DISCOUNT_PRICE_INCREASE_PER_DAY * plusDay);
    }

}
