package christmas.validator;

import static christmas.global.constants.EventValidateConstants.*;

import christmas.exception.InvalidInputException;
import christmas.global.FoodMenu;
import java.util.Arrays;
import java.util.Map;

public class InputFoodMenusValidator {

    public static void validateInputMenuInFoodMenu(String menu) {
        if (Arrays.stream(FoodMenu.values())
                .noneMatch(foodMenu -> foodMenu.getName().equals(menu))) {
            throw new InvalidInputException();
        }
    }

    public static void validateInputFoodMenuCount(Map<FoodMenu, Integer> foodMenus) {
        int foodCount = foodMenus.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        
        if (foodCount < MIN_FOOD_MENU) {
            throw new InvalidInputException();
        }
    }
    public static void validateInputStringFormat(String[] splitInput) {
        for (String string : splitInput) {
            if (!string.contains("-")) {
                throw new InvalidInputException();
            }
        }
    }
    public static void validateInputStringFormat2(String[] splitInput) {
        if (splitInput.length != 2) {
            throw new InvalidInputException();
        }
    }

    public static void validateInputFoodMenuIncludingDuplicate(Map<FoodMenu, Integer> foodMenus) {
        long uniqueMenuCount = foodMenus.keySet()
                .stream()
                .distinct()
                .count();
        if (uniqueMenuCount != foodMenus.size()) {
            throw new InvalidInputException();
        }
    }

}
