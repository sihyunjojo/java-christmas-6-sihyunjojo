package christmas.domain;

import static christmas.global.FoodMenu.*;

import christmas.global.FoodMenu;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("Order 객체 생성 및 속성 확인")
    void testCreateOrder() {
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(T_BONE_STEAK, 1);
        foodMenus.put(BBQ_RIBS, 1);
        foodMenus.put(CHOCOLATE_CAKE, 2);
        foodMenus.put(ZERO_COLA, 1);

        Order order = Order.createOrder(foodMenus);

        Assertions.assertEquals(order, new Order(foodMenus));
        Assertions.assertEquals(order.getOrderPrice(),
                T_BONE_STEAK.getPrice() + BBQ_RIBS.getPrice() +
                        (CHOCOLATE_CAKE.getPrice() * 2) + ZERO_COLA.getPrice());
        Assertions.assertEquals(order.getFoodMenuCount(),
                1 + 1 + 2 + 1);
        Assertions.assertEquals(order.getFoodMenus(),
                foodMenus.keySet().stream().toList());
    }
}