package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.global.FoodMenu;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventPlannerTest {

    @DisplayName("EventPlanner 객체 생성 및 속성 확인 테스트")
    @Test
    void testCreateEventPlanner() {
        // given
        int day = 15;
        LocalDate date = LocalDate.of(2023, 12, day);

        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.T_BONE_STEAK, 1);
        foodMenus.put(FoodMenu.BBQ_RIBS, 1);
        foodMenus.put(FoodMenu.CHOCOLATE_CAKE, 2);
        foodMenus.put(FoodMenu.ZERO_COLA, 1);

        Order order = Order.createOrder(foodMenus);

        // when
        EventPlanner eventPlanner = EventPlanner.createEventPlanner(order, date);

        // then
        assertNotNull(eventPlanner);
        assertEquals(order, eventPlanner.getOrder());
        assertEquals(date, eventPlanner.getDate());
        assertEquals(order.getOrderPrice(), eventPlanner.getOrderPrice());
        assertNotNull(eventPlanner.getBenefits());
        assertNotNull(eventPlanner.getGiveAwayProduct());
        assertTrue(eventPlanner.getAllDiscountPrice() >= 0);
        assertTrue(eventPlanner.getDiscountedOrderPrice() >= 0);
        assertNotNull(eventPlanner.getEventBadge());


    }


}