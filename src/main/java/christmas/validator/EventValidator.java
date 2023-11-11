package christmas.validator;

import static christmas.global.constants.EventValidateConstants.*;

import christmas.exception.InvalidMenuException;
import christmas.exception.InvalidPriceException;
import christmas.global.FoodMenu;
import java.util.Map;

public class EventValidator {
    public static void validateOrderPrice(int orderPrice) {
        if (orderPrice < EVENT_PRICE_CONDITION) {
            throw new InvalidPriceException();
        }
    }

    public static void validateOrderFoodCategory(Map<FoodMenu, Integer> foodMenus) {
        if (foodMenus.keySet()
                .stream()
                .allMatch(foodMenu -> foodMenu
                        .getCategory()
                        .equals(RESTRICTED_CATEGORY))) {
            throw new InvalidMenuException();
        }
    }

    public static void validateOrderFoodCount(Map<FoodMenu, Integer> foodMenus) {
        if (foodMenus.size() < MAX_FOOD_MENU) {
            throw new InvalidMenuException();
        }
    }
}
