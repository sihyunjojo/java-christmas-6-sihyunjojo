package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.InvalidMenuException;
import christmas.exception.InvalidPriceException;
import christmas.global.FoodMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class EventValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 4999})
    @DisplayName("이벤트의 가격 조건에 맞지 않으면, 예외를 발생시켜준다.")
    void testInValidateOrderPrice(int orderPrice) {
        Assertions.assertThrows(InvalidPriceException.class, () -> EventValidator.validateOrderPrice(orderPrice));
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 100000, 200000})
    @DisplayName("이벤트의 가격 조건에 맞지 않으면, 예외가 나타나지 않는다.")
    void testValidateOrderPrice(int orderPrice) {
        Assertions.assertDoesNotThrow( () -> EventValidator.validateOrderPrice(orderPrice));
    }

    @Test
    @DisplayName("음료만 시킬 경우, 예외를 발생시켜준다.")
    void testInValidateOrderFoodCategory() {
        List<FoodMenu> foodMenus = new ArrayList<>();
        foodMenus.add(FoodMenu.ZERO_COLA);
        foodMenus.add(FoodMenu.CHAMPAGNE);

        Assertions.assertThrows(InvalidMenuException.class, () -> EventValidator.validateOrderFoodCategory(foodMenus));
    }
    @Test
    @DisplayName("음료와 음식을 시킬 경우, 예외가 발생하지 않는다.")
    void testValidateOrderFoodCategoryInBeverageWithMain() {
        List<FoodMenu> foodMenus = new ArrayList<>();
        foodMenus.add(FoodMenu.ZERO_COLA);
        foodMenus.add(FoodMenu.BBQ_RIBS);

        Assertions.assertDoesNotThrow(() -> EventValidator.validateOrderFoodCategory(foodMenus));
    }

    @Test
    @DisplayName("메인음식만 시킬 경우, 예외가 발생하지 않는다.")
    void testValidateOrderFoodCategoryInMain() {
        List<FoodMenu> foodMenus = new ArrayList<>();
        foodMenus.add(FoodMenu.CHRISTMAS_PASTA);
        foodMenus.add(FoodMenu.BBQ_RIBS);

        Assertions.assertDoesNotThrow(() -> EventValidator.validateOrderFoodCategory(foodMenus));
    }

    @Test
    @DisplayName("디저트만 시킬 경우, 예외가 발생하지 않는다.")
    void testValidateOrderFoodCategoryInDessert() {
        List<FoodMenu> foodMenus = new ArrayList<>();
        foodMenus.add(FoodMenu.CHOCOLATE_CAKE);
        foodMenus.add(FoodMenu.ICE_CREAM);

        Assertions.assertDoesNotThrow(() -> EventValidator.validateOrderFoodCategory(foodMenus));
    }

    @ParameterizedTest
    @ValueSource(ints = {21,100})
    @DisplayName("메뉴를 20개 초과로 시키면, 예외를 발생시킨다.")
    void testInValidateOrderFoodMenuCount(int foodMenuCount) {
        Assertions.assertThrows(InvalidMenuException.class,() -> EventValidator.validateOrderFoodMenuCount(foodMenuCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,10,20})
    @DisplayName("메뉴를 20개 이하로 시키면, 예외가 발생하지 않는다.")
    void testValidateOrderFoodMenuCount(int foodMenuCount) {
        Assertions.assertDoesNotThrow(() -> EventValidator.validateOrderFoodMenuCount(foodMenuCount));
    }


}