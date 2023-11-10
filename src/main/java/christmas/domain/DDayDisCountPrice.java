package christmas.domain;

import static christmas.global.DisCountPriceConstants.*;
import static christmas.global.DiscountDateConstants.*;

import christmas.validator.DateValidator;
import java.time.LocalDate;

public record DDayDisCountPrice(int discountPrice) {

    public static DDayDisCountPrice createDDayDisCountPrice(LocalDate currentDate) {
        return new DDayDisCountPrice(updateDDayDisCountPrice(currentDate));
    }

    public static int updateDDayDisCountPrice(LocalDate currentDate) {
        DateValidator.validateDDayDisCountPeriod(currentDate);
        int plusDay = currentDate.getDayOfMonth() - D_DAY_DISCOUNT_START_DAY.getDayOfMonth();
        // 음수 예외 처리 후 다시 받는 코드

        return INITIAL_D_DAY_DISCOUNT_PRICE
                + (DISCOUNT_PRICE_INCREASE_PER_DAY * plusDay);
    }

}
