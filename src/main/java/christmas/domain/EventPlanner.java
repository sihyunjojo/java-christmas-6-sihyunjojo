package christmas.domain;

import static christmas.global.BenefitDetail.*;


import christmas.domain.event.GiveAwayEvent;
import christmas.domain.event.discount.DDayDiscount;
import christmas.domain.event.discount.SpecialDiscount;
import christmas.domain.event.discount.WeekdayDiscount;
import christmas.domain.event.discount.WeekendDiscount;
import christmas.global.BenefitDetail;
import christmas.global.EventBadge;
import christmas.global.FoodMenu;
import christmas.validator.BenefitValidator;
import christmas.validator.EventValidator;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EventPlanner {

    private final Order order;
    private final LocalDate date;
    private final int orderPrice;
    private final Map<BenefitDetail,Benefit> benefits;
    private GiveAwayProduct giveAwayProduct = null;
    private final int allDiscountPrice;
    private int discountedOrderPrice;
    private final EventBadge eventBadge;

    private EventPlanner(Order order, LocalDate date, int orderPrice, Map<BenefitDetail,Benefit> benefits) {
        this.order = order;
        this.date = date;
        this.orderPrice = orderPrice;
        this.benefits = benefits;
        this.allDiscountPrice = setAllDiscountPrice(benefits);
        this.discountedOrderPrice = orderPrice - allDiscountPrice;
        this.eventBadge = EventBadge.determineEventBadge(allDiscountPrice);
        isNotNullGiveAwayEvent(benefits);
    }

    private void isNotNullGiveAwayEvent(Map<BenefitDetail, Benefit> benefits) {
        GiveAwayEvent giveAwayEvent = (GiveAwayEvent) benefits.get(GIVE_AWAY_EVENT);
        if (giveAwayEvent != null) {
            this.giveAwayProduct = giveAwayEvent.getGiveAwayProduct();
            this.discountedOrderPrice += giveAwayProduct.product().getPrice();
        }
    }

    private static int setAllDiscountPrice(Map<BenefitDetail, Benefit> benefits) {
        int allDiscountPrice = 0;
        for (Benefit value : benefits.values()) {
            allDiscountPrice += value.getBenefitPrice();
        }
        return allDiscountPrice;
    }


    public static EventPlanner createEventPlanner(Order order, LocalDate date) {
        int orderPrice = order.getOrderPrice();
        Map<BenefitDetail, Benefit> benefits = new HashMap<>();

        if (!EventValidator.validateOrderPrice(order.getOrderPrice())){
            return new EventPlanner(order, date, orderPrice, benefits);
        }

        determineBenefits(order, date, benefits, orderPrice);
        return new EventPlanner(order, date, orderPrice, benefits);
    }

    private static void determineBenefits(Order order, LocalDate date, Map<BenefitDetail, Benefit> benefits, int orderPrice) {
        determineAddSpecialDiscount(date, benefits);
        determineAddGiveAwayEvent(date, orderPrice, benefits);
        determineAddWeekendDiscount(order, date, benefits);
        determineAddWeekdayDiscount(order, date, benefits);
        determineAddDDayDiscount(date, benefits);
    }

    private static void determineAddDDayDiscount(LocalDate date, Map<BenefitDetail, Benefit> benefits) {
        if (BenefitValidator.isDDayDiscountValid(date)) {
            benefits.put(D_DAY_DISCOUNT,DDayDiscount.createDDayDiscount(date));
        }
    }

    private static void determineAddWeekdayDiscount(Order order, LocalDate date, Map<BenefitDetail, Benefit> benefits) {
        if (BenefitValidator.isWeekdayDiscountValid(date)){
            benefits.put(WEEKDAY_DISCOUNT,WeekdayDiscount.createWeekdayDiscount(order));
        }
    }

    private static void determineAddWeekendDiscount(Order order, LocalDate date, Map<BenefitDetail, Benefit> benefits) {
        if (BenefitValidator.isWeekendDiscountValid(date)) {
            benefits.put(WEEKEND_DISCOUNT,WeekendDiscount.createWeekendDiscount(order));
        }
    }

    private static void determineAddGiveAwayEvent(LocalDate date, int orderPrice, Map<BenefitDetail, Benefit> benefits) {
        if (BenefitValidator.isGiveAwayEventValid(date, orderPrice)) {
            GiveAwayProduct giveAwayProduct = GiveAwayProduct.createGiveAwayProduct(FoodMenu.CHAMPAGNE, 1);
            benefits.put(GIVE_AWAY_EVENT,GiveAwayEvent.createGiveAwayEvent(giveAwayProduct));
        }
    }

    private static void determineAddSpecialDiscount(LocalDate date, Map<BenefitDetail, Benefit> benefits) {
        if (BenefitValidator.isSpecialDiscountValid(date)) {
            benefits.put(SPECIAL_DISCOUNT,SpecialDiscount.createSpecialDiscount());
        }
    }


    public Order getOrder() {
        return order;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public Map<BenefitDetail, Benefit> getBenefits() {
        return benefits;
    }

    public GiveAwayProduct getGiveAwayProduct() {
        return giveAwayProduct;
    }

    public int getAllDiscountPrice() {
        return allDiscountPrice;
    }

    public int getDiscountedOrderPrice() {
        return discountedOrderPrice;
    }

    public EventBadge getEventBadge() {
        return eventBadge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EventPlanner that = (EventPlanner) o;
        return orderPrice == that.orderPrice && allDiscountPrice == that.allDiscountPrice
                && discountedOrderPrice == that.discountedOrderPrice && Objects.equals(order, that.order)
                && Objects.equals(date, that.date) && Objects.equals(benefits, that.benefits)
                && Objects.equals(giveAwayProduct, that.giveAwayProduct) && eventBadge == that.eventBadge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, date, orderPrice, benefits, giveAwayProduct, allDiscountPrice, discountedOrderPrice,
                eventBadge);
    }
}
