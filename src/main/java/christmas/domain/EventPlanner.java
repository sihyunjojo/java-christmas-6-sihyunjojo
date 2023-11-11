package christmas.domain;

import christmas.validator.DateValidator;
import java.time.LocalDate;

public class EventPlanner {
    private int orderAllPrice;

    private EventPlanner(int orderAllPrice) {
        this.orderAllPrice = orderAllPrice;
    }

    public static EventPlanner createEventPlanner(Order order, LocalDate date) {
        DateValidator.validateDisCountPeriod(date);

        return new EventPlanner(order.getOrderAllPrice());
    }
}
