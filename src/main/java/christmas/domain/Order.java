package christmas.domain;

import christmas.global.FoodMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public record Order(Map<FoodMenu, Integer> foodMenus) {
    public Order(Map<FoodMenu, Integer> foodMenus) {
        this.foodMenus = new HashMap<>();
    }

    public static Order createOrder(Map<FoodMenu, Integer> foodMenus) {
        return new Order(foodMenus);
    }

    public int getOrderAllPrice(){
        return foodMenus.entrySet()
                .stream()
                .mapToInt(Order::calculateFoodMenuAllPrice)
                .sum();
    }

    private static int calculateFoodMenuAllPrice(Entry<FoodMenu, Integer> foodMenu) {
        return foodMenu.getKey().getPrice() * foodMenu.getValue();
    }

    @Override
    public Map<FoodMenu, Integer> foodMenus() {
        return Collections.unmodifiableMap(foodMenus);
    }
}
