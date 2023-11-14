package christmas.validator;

import static christmas.global.constants.DiscountDateConstants.*;

import christmas.global.StarredDate;
import christmas.global.constants.EventValidateConstants;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class BenefitValidator {
    public static boolean isDDayDiscountValid(LocalDate date){
        return !date.isBefore(D_DAY_DISCOUNT_START_DAY) && !date.isAfter(D_DAY_DISCOUNT_END_DAY);
    }
    public static boolean isSpecialDiscountValid(LocalDate date){
        return StarredDate.isStarredDate(date);
    }
    public static boolean isWeekdayDiscountValid(LocalDate date){
        return !isWeekend(date);
    }
    public static boolean isWeekendDiscountValid(LocalDate date){
        return isWeekend(date);
    }
    public static boolean isGiveAwayEventValid(int orderPrice){
        return orderPrice >= EventValidateConstants.GIVE_AWAY_EVENT_PRICE_CONDITION;
    }

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.FRIDAY;
    }

}
