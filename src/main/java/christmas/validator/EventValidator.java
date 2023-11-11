package christmas.validator;

import static christmas.global.constants.EventValidateConstants.*;

import christmas.exception.InvalidMenuException;
import christmas.exception.InvalidPriceException;
import christmas.global.FoodMenu;
import java.util.List;

public class EventValidator {
    public static void validateOrderPrice(int orderPrice) {
        if (orderPrice < EVENT_PRICE_CONDITION) {
            throw new InvalidPriceException();
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
