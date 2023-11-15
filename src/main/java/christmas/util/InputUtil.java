package christmas.util;

import static christmas.util.Util.findFoodMenuByName;
import static christmas.validator.InputFoodMenusValidator.*;

import christmas.global.FoodMenu;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
            String[] splitString = splitStringByBar(string);

            validateInputStringFormatByCount(splitString);
            String menuName = splitString[0];
            String count = splitString[1];

            validateFoodMenus(menuName, count);
            validateInputFoodMenuIncludingDuplicate(foodMenus, menuName);
            FoodMenu foodMenu = findFoodMenuByName(menuName);
            foodMenus.put(foodMenu, Integer.parseInt(count));
        }
        return foodMenus;
    }

    private static String[] splitStringByBar(String string) {
        return string.split("-");
    }



}
