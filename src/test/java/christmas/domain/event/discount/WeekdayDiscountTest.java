package christmas.domain.event.discount;

import static christmas.global.constants.DisCountPriceConstants.*;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Order;
import christmas.exception.InvalidDateException;
import christmas.global.FoodMenu;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WeekdayDiscountTest {

    @DisplayName("적절한 날(day)이 들어오면 WeekdayDiscount 객체를 생성해준다.")
    @ValueSource(ints = {3, 25, 31})
    @ParameterizedTest
    void testValidInputCreateWeekdayDiscount(int day) {
        LocalDate inputDate = LocalDate.of(2023, 12, day);

        Assertions.assertEquals(WeekdayDiscount.createWeekdayDiscount(inputDate),
                new WeekdayDiscount());
    }

    @DisplayName("부적절한 날(day)이 들어오면 예외를 발생시켜준다.")
    @CsvSource(value = {"2022:10:10", "2023:11:30", "2024:01:01"}, delimiter = ':')
    @ParameterizedTest
    void testInvalidInputCreateWeekdayDiscount(int year, int month, int day) {
        LocalDate inputDate = LocalDate.of(year, month, day);

        Assertions.assertThrows(InvalidDateException.class, () -> WeekdayDiscount.createWeekdayDiscount(inputDate));
    }

    @DisplayName("전체주문가격이 들어오면 평일할인정책에 따라 평일할인 가격만큼 깍은 가격을 반환해준다.")
    @ValueSource(ints = {1,2})
    @ParameterizedTest
    void testDiscountAllOrderPrice(int dessertCount) {
        LocalDate inputDate = LocalDate.of(2023, 12, 1);
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.BBQ_RIBS, 4);
        foodMenus.put(FoodMenu.CHOCOLATE_CAKE, dessertCount);
        Order order = Order.createOrder(foodMenus);

        WeekdayDiscount weekdayDiscount = WeekdayDiscount.createWeekdayDiscount(inputDate);
        Assertions.assertEquals(weekdayDiscount.discountAllOrderPrice(order), order.getOrderAllPrice() - (WEEKDAY_DISCOUNT_PRICE * dessertCount));
    }

    @DisplayName("디저트종류의 가격을 평일할인 가격만큼 깍은 가격을 반환해준다.")
    @ValueSource(ints = {1,2,4})
    @ParameterizedTest
    void testCalculateDiscountedDessertPrice(int day) {
        // given
        LocalDate inputDate = LocalDate.of(2023, 12, day);
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.CHOCOLATE_CAKE, 1);
        Order order = Order.createOrder(foodMenus);

        // when
        WeekdayDiscount weekdayDiscount = WeekdayDiscount.createWeekdayDiscount(inputDate);

        // then
        Assertions.assertEquals(weekdayDiscount.calculateDiscountedDessertPrice(foodMenus), order.getOrderAllPrice() - WEEKDAY_DISCOUNT_PRICE);
    }

    @DisplayName("디저트종류가 아닌 음식메뉴의 가격을 반환해준다.")
    @ValueSource(ints = {1,2,20})
    @ParameterizedTest
    void testCalculateOtherFoodMenuPrice(int day) {
        // given
        LocalDate inputDate = LocalDate.of(2023, 12, day);
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.BBQ_RIBS, 1);
        foodMenus.put(FoodMenu.ZERO_COLA, 2);
        Order order = Order.createOrder(foodMenus);

        // when
        WeekdayDiscount weekdayDiscount = WeekdayDiscount.createWeekdayDiscount(inputDate);

        // then
        Assertions.assertEquals(weekdayDiscount.calculateOtherFoodMenuPrice(foodMenus), order.getOrderAllPrice());
    }

}