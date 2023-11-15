package christmas.util;

import static christmas.message.SystemMessage.*;
import static christmas.util.Util.*;

import christmas.domain.GiveAwayProduct;
import christmas.global.FoodMenu;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OutputUtilTest {

    @ParameterizedTest
    @ValueSource(ints = {10000, 20000, 100000})
    @DisplayName("setMessage메서드가 인자를 하나 받았을때, 원하는 문자열을 만들어주는지 테스트")
    void setMessage_withOneArgument(int price) {
        String result = OutputUtil.setMessage(OUTPUT_PRICE_MESSAGE, price);

        String expectedMessage = String.format("%,d원", price);
        Assertions.assertEquals(expectedMessage, result);
    }

    @ParameterizedTest
    @CsvSource({"타파스, 1", "제로콜라, 2","티본스테이크, 10"})
    @DisplayName("setMessage메서드가 인자를 두개 받았을때, 원하는 문자열을 만들어주는지 테스트")
    void setMessage_withTwoArguments(String foodName, Integer foodCount) {
        String result = OutputUtil.setMessage(OUTPUT_MENU_NAME_AND_COUNT_MESSAGE, foodName, foodCount);

        String expectedMessage = foodName + " " + foodCount + "개";
        Assertions.assertEquals(expectedMessage, result);
    }
    @ParameterizedTest
    @CsvSource({"타파스, 1", "제로콜라, 2","티본스테이크, 10"})
    @DisplayName("FoodMenuMessage를 생성해주는 테스트")
    void testSetFoodMenuMessage(String foodName, Integer foodCount) {
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(findFoodMenuByName(foodName), foodCount);

        for (Entry<FoodMenu, Integer> foodMenu : foodMenus.entrySet()) {
            String actualMessage = OutputUtil.setFoodMenuMessage(foodMenu);

            String expectedMessage = foodName + " " + foodCount + "개";
            Assertions.assertEquals(expectedMessage, actualMessage);
        }
    }

    @ParameterizedTest
    @CsvSource({"타파스, 1", "제로콜라, 2","티본스테이크, 10"})
    @DisplayName("GiveAwayProductMessage를 생성해주는 테스트")
    void testSetGiveAwayProductMessage(String productName, int productCount) {
        GiveAwayProduct giveAwayProduct = new GiveAwayProduct(findFoodMenuByName(productName), productCount);

        String actualMessage = OutputUtil.setGiveAwayProductMessage(giveAwayProduct);

        String expectedMessage = productName + " " + productCount + "개";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}