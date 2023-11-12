package christmas.domain.event.discount;

import static christmas.domain.event.discount.WeekendDiscount.createWeekendDiscount;
import static christmas.global.constants.DisCountPriceConstants.*;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Order;
import christmas.exception.InvalidDateException;
import christmas.global.FoodMenu;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WeekendDiscountTest {

    @DisplayName("적절한 날(day)이 들어오면 WeekendDiscount 객체를 생성해준다.")
    @ValueSource(ints = {2, 9, 24, 30})
    @ParameterizedTest
    void testValidInputCreateWeekendDiscount(int day) {
        LocalDate inputDate = LocalDate.of(2023, 12, day);

        Assertions.assertEquals(createWeekendDiscount(inputDate),
                new WeekendDiscount());
    }

    @DisplayName("주말 할인 객체를 만들때, 부적절한 날(day)이 들어오면 예외를 발생시켜준다.")
    @CsvSource(value = {"2022:10:10", "2023:11:30", "2024:01:01"}, delimiter = ':')
    @ParameterizedTest
    void testInvalidInputCreateWeekendDiscount(int year, int month, int day) {
        LocalDate inputDate = LocalDate.of(year, month, day);

        Assertions.assertThrows(InvalidDateException.class, () -> createWeekendDiscount(inputDate));
    }

    @DisplayName("전체주문가격이 들어오면 주말할인정책에 따라 주말할인 가말격만큼 깍은 가격을 반환해준다.")
    @ValueSource(ints = {2,10,23})
    @ParameterizedTest
    void testDiscountAllOrderPrice(int mainCount) {
        LocalDate inputDate = LocalDate.of(2023, 12, 1);
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.BBQ_RIBS, mainCount);
        foodMenus.put(FoodMenu.CHOCOLATE_CAKE, 2);
        Order order = Order.createOrder(foodMenus);

        WeekendDiscount WeekendDiscount = createWeekendDiscount(inputDate);
        Assertions.assertEquals(WeekendDiscount.discountAllOrderPrice(order), order.getOrderAllPrice() - (WEEKEND_DISCOUNT_PRICE * mainCount));
    }

    @DisplayName("메인음식 종류의 가격을 주말할인 가격만큼 깍은 가격을 반환해준다.")
    @ValueSource(ints = {2,10,23})
    @ParameterizedTest
    void testCalculateDiscountedDessertPrice(int day) {
        // given
        LocalDate inputDate = LocalDate.of(2023, 12, day);
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.BBQ_RIBS, 1);
        Order order = Order.createOrder(foodMenus);

        // when
        WeekendDiscount weekendDiscount = createWeekendDiscount(inputDate);

        // then
        Assertions.assertEquals(weekendDiscount.calculateDiscountedDessertPrice(foodMenus), order.getOrderAllPrice() - WEEKEND_DISCOUNT_PRICE);
    }

    @DisplayName("메인음식 종류가 아닌 음식메뉴의 가격을 반환해준다.")
    @ValueSource(ints = {2,10,23})
    @ParameterizedTest
    void testCalculateOtherFoodMenuPrice(int day) {
        // given
        LocalDate inputDate = LocalDate.of(2023, 12, day);
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.CHOCOLATE_CAKE, 1);
        foodMenus.put(FoodMenu.ZERO_COLA, 2);
        Order order = Order.createOrder(foodMenus);

        // when
        WeekendDiscount weekendDiscount = createWeekendDiscount(inputDate);

        // then
        Assertions.assertEquals(weekendDiscount.calculateOtherFoodMenuPrice(foodMenus), order.getOrderAllPrice());
    }

}