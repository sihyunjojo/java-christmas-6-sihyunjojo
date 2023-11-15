package christmas.util;

import christmas.global.FoodMenu;

public class Util {
    public static FoodMenu findFoodMenuByName(String menuName) {
        for (FoodMenu foodMenu : FoodMenu.values()) {
            if (foodMenu.getName().equals(menuName)) {
                return foodMenu;
            }
        }
        return null;
    }
}
