package christmas.validator;

import static christmas.global.constants.DiscountDateConstants.DECEMBER_DISCOUNT_END_DAY;
import static christmas.global.constants.DiscountDateConstants.DECEMBER_DISCOUNT_START_DAY;
import static christmas.global.constants.EventValidateConstants.*;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidMenuException;
import christmas.global.FoodMenu;
import java.time.LocalDate;
import java.util.List;

public class EventValidator {
    public static boolean validateOrderPrice(int orderPrice) {
        return orderPrice >= EVENT_PRICE_CONDITION;
    }

    public static void validateDisCountPeriod(LocalDate currentDate) {
        if (currentDate.isBefore(DECEMBER_DISCOUNT_START_DAY) || currentDate.isAfter(DECEMBER_DISCOUNT_END_DAY)) {
            throw new InvalidDateException();
        }
    }
    public static void validateOrderFoodCategory(List<FoodMenu> foodMenus) {
        if (foodMenus.stream()
                .allMatch(foodMenu -> foodMenu
                        .getCategory()
                        .equals(RESTRICTED_CATEGORY))) {
            throw new InvalidMenuException();
        }
    }

    public static void validateOrderFoodMenuCount(int foodMenuCount) {
        if (foodMenuCount > MAX_FOOD_MENU) {
            throw new InvalidMenuException();
        }
    }
}
