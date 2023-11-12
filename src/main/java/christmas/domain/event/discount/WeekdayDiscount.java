package christmas.domain.event.discount;

import static christmas.global.constants.DisCountPriceConstants.WEEKDAY_DISCOUNT_PRICE;

import christmas.domain.Order;
import christmas.global.FoodMenu;
import christmas.validator.DateValidator;
import java.time.LocalDate;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class WeekdayDiscount {

    private final int discountPrice = WEEKDAY_DISCOUNT_PRICE;

    public WeekdayDiscount() {
    }

    public static WeekdayDiscount createWeekdayDiscount(LocalDate date) {
        DateValidator.validateDisCountPeriod(date);
        return new WeekdayDiscount();
    }

    public int discountAllOrderPrice(Order order) {
        Map<FoodMenu, Integer> foodMenus = order.foodMenus();
        int disCountedDessertPrice = calculateDiscountedDessertPrice(foodMenus);
        int otherFoodMenuPrice = calculateOtherFoodMenuPrice(foodMenus);

        return disCountedDessertPrice + otherFoodMenuPrice;
    }

    public int calculateOtherFoodMenuPrice(Map<FoodMenu, Integer> foodMenus) {
          return foodMenus.entrySet()
                .stream()
                .filter(foodMenu -> !foodMenu.getKey().getCategory().equals("Dessert"))
                .mapToInt(otherFoodMenu -> otherFoodMenu.getValue() * otherFoodMenu.getKey().getPrice())
                .sum();
    }

    public int calculateDiscountedDessertPrice(Map<FoodMenu, Integer> foodMenus) {
        return foodMenus.entrySet()
                .stream()
                .filter(foodMenu -> foodMenu.getKey().getCategory().equals("Dessert"))
                .mapToInt(dessertMenu -> (dessertMenu.getValue() * (dessertMenu.getKey().getPrice() - discountPrice)))
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WeekdayDiscount that = (WeekdayDiscount) o;
        return discountPrice == that.discountPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountPrice);
    }
}
