package christmas.domain.event.discount;

import static christmas.global.BenefitDetail.WEEKEND_DISCOUNT;
import static christmas.global.constants.DisCountPriceConstants.WEEKEND_DISCOUNT_PRICE;

import christmas.domain.Benefit;
import christmas.domain.Order;
import christmas.global.FoodMenu;
import java.util.Map;
import java.util.Objects;

public class WeekendDiscount extends Benefit {
    private final int allDisCountPrice;

    public WeekendDiscount(int allDisCountPrice) {
        this.allDisCountPrice = allDisCountPrice;
    }

    public static WeekendDiscount createWeekendDiscount(Order order) {
        int allDisCountPrice = calculateDiscountedPrice(order);
        return new WeekendDiscount(allDisCountPrice);
    }

    public int discountOrderPrice(Order order) {
        int orderPrice = order.getOrderPrice();
        return orderPrice - allDisCountPrice;
    }

    private static int calculateDiscountedPrice(Order order) {
        Map<FoodMenu, Integer> foodMenus = order.foodMenus();

        return foodMenus.entrySet()
                .stream()
                .filter(foodMenu -> foodMenu.getKey().getCategory().equals("Main"))
                .mapToInt(mainMenu -> (mainMenu.getValue() *  WEEKEND_DISCOUNT_PRICE))
                .sum();
    }

    @Override
    public String getDescription() {
        return WEEKEND_DISCOUNT.getMessage();
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
        WeekendDiscount that = (WeekendDiscount) o;
        return allDisCountPrice == that.allDisCountPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(allDisCountPrice);
    }
}
