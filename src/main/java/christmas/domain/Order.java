package christmas.domain;

import christmas.global.FoodMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public record Order(Map<FoodMenu, Integer> foodMenus) {
    public Order(Map<FoodMenu, Integer> foodMenus) {
        this.foodMenus = new HashMap<>();
    }

    public static Order createOrder(Map<FoodMenu, Integer> foodMenus) {
        return new Order(foodMenus);
    }

    @Override
    public Map<FoodMenu, Integer> foodMenus() {
        return Collections.unmodifiableMap(foodMenus);
    }
}
