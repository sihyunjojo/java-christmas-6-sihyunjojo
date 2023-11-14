package christmas.controller;


import static christmas.message.SystemMessage.*;

import christmas.domain.EventPlanner;
import christmas.domain.Order;
import christmas.global.FoodMenu;
import christmas.handler.OutputHandler;
import christmas.validator.EventValidator;
import christmas.handler.InputHandler;
import christmas.view.OutputView;
import java.time.LocalDate;
import java.util.Map;


public class EventPlannerController {
    public static void planEvent() {
        OutputView.printMessage(HELLO_EVENT_PLANNER);
        LocalDate date = InputHandler.setDate();
        Map<FoodMenu, Integer> foodMenus = InputHandler.setFoodMenus();

        Order order = Order.createOrder(foodMenus);

        EventValidator.validateDisCountPeriod(date);
        EventValidator.validateOrderFoodCategory(order.getFoodMenus());
        EventValidator.validateOrderFoodMenuCount(order.getFoodMenuCount());

        EventPlanner eventPlanner = EventPlanner.createEventPlanner(order, date);

        OutputHandler.outputEventPlanner(eventPlanner);
    }
}
