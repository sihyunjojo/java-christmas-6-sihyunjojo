package christmas.controller;

import christmas.domain.event.discount.DDayDiscount;
import java.time.LocalDate;


public class EventPlannerController {
    public static void planEvent() {
        int allOrderPrice = 0;
        LocalDate inputDate = LocalDate.of(2023, 12, 1);


        DDayDiscount dDayDiscount = DDayDiscount.createDDayDiscount(inputDate);
        int discountedPrices = dDayDiscount.discountOrderPrice(allOrderPrice);
    }
}
