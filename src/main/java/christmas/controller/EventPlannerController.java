package christmas.controller;


import static christmas.message.SystemMessage.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.EventPlanner;
import christmas.domain.Order;
import christmas.handler.OutputHandler;
import christmas.handler.InputHandler;
import christmas.view.OutputView;
import java.time.LocalDate;


public class EventPlannerController {
    public static void planEvent() {
        OutputView.printMessage(HELLO_EVENT_PLANNER);
//        LocalDate date = InputHandler.setDate();
//        Order order = InputHandler.setOrder();

//        EventPlanner eventPlanner = EventPlanner.createEventPlanner(order, date);

//        OutputHandler.outputEventPlanner(eventPlanner);
        Console.close();
    }
}
