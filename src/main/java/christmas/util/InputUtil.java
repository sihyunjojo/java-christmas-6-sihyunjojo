package christmas.util;

import static christmas.validator.InputFoodMenusValidator.*;
import static christmas.validator.InputValidator.validateInputStringParseInteger;

import christmas.global.FoodMenu;
import christmas.validator.InputValidator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class InputUtil {

    public static int StringToInt(String input) {
        return Integer.parseInt(input);
    }
    public static String[] splitStringByComma(String input) {
        return input.split(",");
    }

    public static Map<FoodMenu, Integer> StringsToFoodMenus(String[] input) {
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();

        for (String string : input) {
            String[] splitString = string.split("-");
            validateInputStringFormat2(splitString);

            String menuName = splitString[0];
            String count = splitString[1];
            validateInputMenuInFoodMenu(menuName);
            validateInputStringParseInteger(count);

            FoodMenu foodMenu = findFoodMenuByName(menuName);
            foodMenus.put(foodMenu, Integer.parseInt(count));
        }

        return foodMenus;
    }

    private static FoodMenu findFoodMenuByName(String menuName) {
        for (FoodMenu foodMenu : FoodMenu.values()) {
            if (foodMenu.getName().equals(menuName)) {
                return foodMenu;
            }
        }
        return null;
    }

}
