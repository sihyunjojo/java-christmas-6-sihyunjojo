//package christmas.validator;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import christmas.exception.InvalidDateException;
//import christmas.exception.InvalidOrderException;
//import christmas.global.FoodMenu;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//
//class EventValidatorTest {
//
//    @ParameterizedTest
//    @ValueSource(ints = {0, 1000, 4999})
//    @DisplayName("이벤트의 가격 조건에 맞지 않으면, False를 반환해준다.")
//    void testInValidateOrderPrice(int orderPrice) {
//        Assertions.assertFalse(EventValidator.validateOrderPrice(orderPrice));
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {10000, 100000, 200000})
//    @DisplayName("이벤트의 가격 조건에 맞으면, True를 반환해준다.")
//    void testValidateOrderPrice(int orderPrice) {
//        Assertions.assertTrue(EventValidator.validateOrderPrice(orderPrice));
//    }
//
//    @DisplayName("12월 할인기간 이외의 기간은 잘못된 날짜 예외 에러를 발생시켜준다.")
//    @CsvSource(value = {"2022:10:10", "2023:11:30", "2024:01:01"}, delimiter = ':')
//    @ParameterizedTest
//    void testInvalidateDisCountPeriod(int year, int month, int day) {
//        // given
//        LocalDate inputDate = LocalDate.of(year, month, day);
//
//        // then
//        assertThrows(InvalidDateException.class, () -> EventValidator.validateDisCountPeriod(inputDate));
//    }
//    @DisplayName("12월 할인기간 이내의 기간이 들어오면, 예외가 발생하지 않는다.")
//    @ValueSource(ints = {1, 10, 25, 31})
//    @ParameterizedTest
//    void testValidateDisCountPeriod(int day) {
//        // given
//        LocalDate inputDate = LocalDate.of(2023, 12, day);
//
//        // then
//        assertDoesNotThrow(() -> EventValidator.validateDisCountPeriod(inputDate));
//    }
//
//
//    @Test
//    @DisplayName("음료만 시킬 경우, 예외를 발생시켜준다.")
//    void testInValidateOrderFoodCategory() {
//        List<FoodMenu> foodMenus = new ArrayList<>();
//        foodMenus.add(FoodMenu.ZERO_COLA);
//        foodMenus.add(FoodMenu.CHAMPAGNE);
//
//        Assertions.assertThrows(InvalidOrderException.class, () -> EventValidator.validateOrderFoodCategory(foodMenus));
//    }
//    @Test
//    @DisplayName("음료와 음식을 시킬 경우, 예외가 발생하지 않는다.")
//    void testValidateOrderFoodCategoryInBeverageWithMain() {
//        List<FoodMenu> foodMenus = new ArrayList<>();
//        foodMenus.add(FoodMenu.ZERO_COLA);
//        foodMenus.add(FoodMenu.BBQ_RIBS);
//
//        Assertions.assertDoesNotThrow(() -> EventValidator.validateOrderFoodCategory(foodMenus));
//    }
//
//    @Test
//    @DisplayName("메인음식만 시킬 경우, 예외가 발생하지 않는다.")
//    void testValidateOrderFoodCategoryInMain() {
//        List<FoodMenu> foodMenus = new ArrayList<>();
//        foodMenus.add(FoodMenu.CHRISTMAS_PASTA);
//        foodMenus.add(FoodMenu.BBQ_RIBS);
//
//        Assertions.assertDoesNotThrow(() -> EventValidator.validateOrderFoodCategory(foodMenus));
//    }
//
//    @Test
//    @DisplayName("디저트만 시킬 경우, 예외가 발생하지 않는다.")
//    void testValidateOrderFoodCategoryInDessert() {
//        List<FoodMenu> foodMenus = new ArrayList<>();
//        foodMenus.add(FoodMenu.CHOCOLATE_CAKE);
//        foodMenus.add(FoodMenu.ICE_CREAM);
//
//        Assertions.assertDoesNotThrow(() -> EventValidator.validateOrderFoodCategory(foodMenus));
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {21,100})
//    @DisplayName("메뉴를 20개 초과로 시키면, 예외를 발생시킨다.")
//    void testInValidateOrderFoodMenuCount(int foodMenuCount) {
//        Assertions.assertThrows(InvalidOrderException.class,() -> EventValidator.validateOrderFoodMenuCount(foodMenuCount));
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {1,10,20})
//    @DisplayName("메뉴를 20개 이하로 시키면, 예외가 발생하지 않는다.")
//    void testValidateOrderFoodMenuCount(int foodMenuCount) {
//        Assertions.assertDoesNotThrow(() -> EventValidator.validateOrderFoodMenuCount(foodMenuCount));
//    }
//
//
//}