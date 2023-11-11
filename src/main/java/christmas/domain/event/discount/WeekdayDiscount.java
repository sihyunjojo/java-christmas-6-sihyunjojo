package christmas.domain.event.discount;

import static christmas.global.DisCountPriceConstants.WEEKDAY_DISCOUNT_PRICE;

import christmas.domain.Order;
import christmas.global.FoodMenu;
import java.util.Map;

public class WeekdayDiscount {

    private final int discountPrice = WEEKDAY_DISCOUNT_PRICE;

    public WeekdayDiscount() {
    }

    public static WeekdayDiscount createWeekdayDiscount() {
        return new WeekdayDiscount();
    }

    public int discountAllOrderPrice(Order order) {
        Map<FoodMenu, Integer> foodMenus = order.foodMenus();
        int disCountedDessertPrice = calculateDiscountedDessertPrice(foodMenus);
        int otherFoodMenuPrice = calculateDiscountedOtherFoodMenuPrice(foodMenus);

        return disCountedDessertPrice + otherFoodMenuPrice;
    }

    private static int calculateDiscountedOtherFoodMenuPrice(Map<FoodMenu, Integer> foodMenus) {
        return foodMenus.entrySet()
                .stream()
                .filter(foodMenu -> !foodMenu.getKey().getCategory().equals("Dessert"))
                .mapToInt(otherFoodMenu -> otherFoodMenu.getValue() * otherFoodMenu.getKey().getPrice())
                .sum();
    }

    private int calculateDiscountedDessertPrice(Map<FoodMenu, Integer> foodMenus) {
        return foodMenus.entrySet()
                .stream()
                .filter(foodMenu -> foodMenu.getKey().getCategory().equals("Dessert"))
                .mapToInt(dessertMenu -> dessertMenu.getValue() * (dessertMenu.getKey().getPrice() - discountPrice))
                .sum();
    }

}
