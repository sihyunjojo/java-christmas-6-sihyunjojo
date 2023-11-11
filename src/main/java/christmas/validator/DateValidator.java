package christmas.validator;

import static christmas.global.constants.DiscountDateConstants.*;

import christmas.exception.InvalidDateException;
import christmas.global.StarredDate;
import java.time.LocalDate;
import java.util.Arrays;

public class DateValidator {

    public static void validateDDayDisCountPeriod(LocalDate currentDate) {
        if (currentDate.isBefore(D_DAY_DISCOUNT_START_DAY) || currentDate.isAfter(D_DAY_DISCOUNT_END_DAY)) {
            throw new InvalidDateException();
        }
    }
    public static void validateDisCountPeriod(LocalDate currentDate) {
        if (currentDate.isBefore(DECEMBER_DISCOUNT_START_DAY) || currentDate.isAfter(DECEMBER_DISCOUNT_END_DAY)) {
            throw new InvalidDateException();
        }
    }
    public static void validateSpecialDisCountPeriod(LocalDate currentDate) {
        if (!StarredDate.isStarredDate(currentDate)) {
            throw new InvalidDateException();
        }
    }
}
