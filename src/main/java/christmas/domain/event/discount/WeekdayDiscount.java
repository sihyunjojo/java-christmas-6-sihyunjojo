package christmas.domain.event.discount;

import static christmas.global.BenefitDetail.WEEKDAY_DISCOUNT;
import static christmas.global.constants.DisCountPriceConstants.WEEKDAY_DISCOUNT_PRICE;

import christmas.domain.Benefit;
import christmas.domain.Order;
import christmas.global.FoodMenu;
import java.util.Map;
import java.util.Objects;

public class WeekdayDiscount extends Benefit {
    private final int allDisCountPrice;

    public WeekdayDiscount(int allDisCountPrice) {
        this.allDisCountPrice = allDisCountPrice;
    }

    public static WeekdayDiscount createWeekdayDiscount(Order order) {
        int allDisCountPrice = calculateDiscountedPrice(order);
        return new WeekdayDiscount(allDisCountPrice);
    }

    private static int calculateDiscountedPrice(Order order) {
        Map<FoodMenu, Integer> foodMenus = order.foodMenus();

        return foodMenus.entrySet()
                .stream()
                .filter(foodMenu -> foodMenu.getKey()
                        .getCategory()
                        .equals("Dessert"))
                .mapToInt(mainMenu -> (mainMenu.getValue() *  WEEKDAY_DISCOUNT_PRICE))
                .sum();
    }

    @Override
    public String getName() {
        return WEEKDAY_DISCOUNT.getName();
    }

    @Override
    public int getBenefitPrice() {
        return allDisCountPrice;
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
        return allDisCountPrice == that.allDisCountPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(allDisCountPrice);
    }
}
