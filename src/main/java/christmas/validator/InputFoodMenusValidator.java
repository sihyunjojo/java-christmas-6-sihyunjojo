package christmas.validator;

import static christmas.global.constants.EventValidateConstants.*;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidInputException;
import christmas.exception.InvalidOrderException;
import christmas.global.FoodMenu;
import christmas.message.ErrorMessage;
import christmas.view.OutputView;
import java.util.Arrays;
import java.util.Map;

public class InputFoodMenusValidator {

    public static void validateFoodMenus(String menuName, String count) {
        validateInputFoodCountParseInteger(count);
        validateInputMenuInFoodMenu(menuName);
    }
    private static void validateInputFoodCountParseInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new InvalidOrderException();
        }
    }

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

        System.out.println(foodCount);
        if (foodCount < MIN_FOOD_MENU) {
            throw new InvalidInputException();
        }
    }
    public static void validateSplitFoodMenus(String[] splitFoodMenus){
        for (String splitFoodMenu : splitFoodMenus) {
            validateInputStringFormatByBar(splitFoodMenu);
        }
    }

    public static void validateInputStringFormatByBar(String string) {
        if (!string.contains("-")) {
            throw new InvalidInputException();
        }
    }

    public static void validateInputStringFormatByCount(String[] splitInput) {
        if (splitInput.length != 2) {
            throw new InvalidInputException();
        }
    }

    public static void validateInputFoodMenuIncludingDuplicate(Map<FoodMenu, Integer> foodMenus, String menuName) {
        for (FoodMenu foodMenu : foodMenus.keySet()) {
            if (foodMenu.getName().equals(menuName)) {
                throw new InvalidInputException();
            }
        }
    }

}
