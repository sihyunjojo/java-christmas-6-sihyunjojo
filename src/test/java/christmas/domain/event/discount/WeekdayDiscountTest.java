package christmas.domain.event.discount;

import static christmas.global.constants.DisCountPriceConstants.*;

import christmas.domain.Order;
import christmas.global.FoodMenu;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WeekdayDiscountTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("주문이 들어오면 WeekdayDiscount 객체를 생성해준다.")
    void testValidInputCreateWeekdayDiscount(int dessertCount) {
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.BBQ_RIBS, 4);
        foodMenus.put(FoodMenu.CHOCOLATE_CAKE, dessertCount);

        Order order = Order.createOrder(foodMenus);

        Assertions.assertEquals(WeekdayDiscount.createWeekdayDiscount(order),
                new WeekdayDiscount(WEEKDAY_DISCOUNT_PRICE * dessertCount));
    }

    @DisplayName("전체주문가격이 들어오면 평일할인정책에 따라 평일할인 가격만큼 깍은 가격을 반환해준다.")
    @ValueSource(ints = {1,10})
    @ParameterizedTest
    void testDiscountAllOrderPrice(int dessertCount) {
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.BBQ_RIBS, 4);
        foodMenus.put(FoodMenu.CHOCOLATE_CAKE, dessertCount);
        Order order = Order.createOrder(foodMenus);

        WeekdayDiscount weekdayDiscount = WeekdayDiscount.createWeekdayDiscount(order);
        Assertions.assertEquals(weekdayDiscount.discountOrderPrice(order), order.getOrderPrice() - (WEEKDAY_DISCOUNT_PRICE * dessertCount));
    }

}