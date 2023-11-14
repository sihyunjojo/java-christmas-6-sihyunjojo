package christmas.validator;

import static christmas.global.constants.EventValidateConstants.*;

import christmas.exception.InvalidMenuException;
import christmas.exception.InvalidPriceException;
import christmas.global.FoodMenu;
import java.util.List;

public class EventValidator {
    public static boolean validateOrderPrice(int orderPrice) {
        return orderPrice >= EVENT_PRICE_CONDITION;
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
