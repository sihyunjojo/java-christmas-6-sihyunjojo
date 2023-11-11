package christmas.controller;

import christmas.domain.event.discount.DDayDiscount;


public class EventPlannerController {
    public static void planEvent() {
        int allOrderPrice = 0;
        int day = 1;

        DDayDiscount dDayDiscount = DDayDiscount.createDDayDiscount(day);
        int discountedPrices = dDayDiscount.discountAllOrderPrice(allOrderPrice);
    }
}
