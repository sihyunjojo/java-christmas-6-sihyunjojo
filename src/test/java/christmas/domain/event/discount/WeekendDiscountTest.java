package christmas.domain.event.discount;

import static christmas.domain.event.discount.WeekendDiscount.createWeekendDiscount;
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

class WeekendDiscountTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("적절한 날(day)이 들어오면 WeekendDiscount 객체를 생성해준다.")
    void testValidInputCreateWeekendDiscount(int mainMenuCount) {
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.BBQ_RIBS, mainMenuCount);
        foodMenus.put(FoodMenu.CHOCOLATE_CAKE, 2);

        Order order = Order.createOrder(foodMenus);

        Assertions.assertEquals(WeekendDiscount.createWeekendDiscount(order),
                new WeekendDiscount(WEEKEND_DISCOUNT_PRICE * mainMenuCount));

    }

}