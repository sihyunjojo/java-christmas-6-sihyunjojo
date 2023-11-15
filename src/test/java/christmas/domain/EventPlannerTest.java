package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.global.EventBadge;
import christmas.global.FoodMenu;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventPlannerTest {

    @Test
    @DisplayName("EventPlanner 객체 생성 및 속성 확인 테스트")
    void testCreateEventPlanner() {
        LocalDate date = LocalDate.of(2023, 12, 3);

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

    @Test
    @DisplayName("혜택이 없는 EventPlanner 객체 생성 및 속성 확인 테스트")
    void testCreateNotBenefitEventPlanner() {
        LocalDate date = LocalDate.of(2023, 12, 23);

        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.TAPAS, 1);
        foodMenus.put(FoodMenu.ZERO_COLA, 1);

        Order order = Order.createOrder(foodMenus);

        // when
        EventPlanner eventPlanner = EventPlanner.createEventPlanner(order, date);

        // then
        assertNotNull(eventPlanner);
        assertEquals(order, eventPlanner.getOrder());
        assertEquals(date, eventPlanner.getDate());
        assertEquals(order.getOrderPrice(), eventPlanner.getOrderPrice());
        assertTrue(eventPlanner.getBenefits().isEmpty());
        assertNull(eventPlanner.getGiveAwayProduct());
        assertEquals(0, eventPlanner.getAllDiscountPrice());
        assertTrue(eventPlanner.getDiscountedOrderPrice() >= 0);
        assertEquals(eventPlanner.getEventBadge(), EventBadge.no);
    }


}