package christmas.domain;

import christmas.global.FoodMenu;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public record Order(Map<FoodMenu, Integer> foodMenus) {
    public static Order createOrder(Map<FoodMenu, Integer> foodMenus) {
        return new Order(foodMenus);
    }

    public int getOrderPrice(){
        return foodMenus.entrySet()
                .stream()
                .mapToInt(this::calculateFoodMenuAllPrice)
                .sum();
    }

    private int calculateFoodMenuAllPrice(Entry<FoodMenu, Integer> foodMenu) {
        return foodMenu.getKey().getPrice() * foodMenu.getValue();
    }
    public int getFoodMenuCount() {
        return foodMenus
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<FoodMenu> getFoodMenus() {
        return foodMenus.keySet()
                .stream()
                .toList();
    }

    @Override
    public Map<FoodMenu, Integer> foodMenus() {
        return Collections.unmodifiableMap(foodMenus);
    }


}
