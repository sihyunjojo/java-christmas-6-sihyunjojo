package christmas.validator;

import static christmas.global.DiscountDateConstants.*;

import christmas.exception.InvalidDateException;
import java.time.LocalDate;

public class DateValidator {

    public static void validateDDayDisCountPeriod(LocalDate currentDate) {
        if (currentDate.isBefore(D_DAY_DISCOUNT_START_DAY) || currentDate.isAfter(D_DAY_DISCOUNT_END_DAY)) {
            throw new InvalidDateException();
        }
    }
}
