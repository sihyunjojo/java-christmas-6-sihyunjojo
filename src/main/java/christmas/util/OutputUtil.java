package christmas.util;

import static christmas.message.SystemMessage.OUTPUT_MENU_NAME_AND_COUNT_MESSAGE;

import christmas.domain.GiveAwayProduct;
import christmas.global.FoodMenu;
import christmas.message.MessageProvider;
import java.util.Map.Entry;

public class OutputUtil {
    @SafeVarargs
    public static <T> String setMessage(MessageProvider message, T... values) {
        return String.format(message.getMessage(), (Object[]) values);
    }
    public static String setFoodMenuMessage(Entry<FoodMenu, Integer> foodMenu) {
        String foodName = foodMenu.getKey().getName();
        Integer foodCount = foodMenu.getValue();

        return setMessage(OUTPUT_MENU_NAME_AND_COUNT_MESSAGE,foodName, foodCount);
    }
    public static String setGiveAwayProductMessage(GiveAwayProduct giveAwayProduct) {
        String giveAwayProductName = giveAwayProduct.product().getName();
        int giveAwayProductCount = giveAwayProduct.count();

        return setMessage(OUTPUT_MENU_NAME_AND_COUNT_MESSAGE, giveAwayProductName, giveAwayProductCount);
    }

}
