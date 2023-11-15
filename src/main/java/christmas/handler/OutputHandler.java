package christmas.handler;

import static christmas.message.SystemMessage.*;
import static christmas.util.OutputUtil.*;

import christmas.domain.Benefit;
import christmas.domain.EventPlanner;
import christmas.domain.GiveAwayProduct;
import christmas.domain.Order;
import christmas.global.BenefitDetail;
import christmas.global.EventBadge;
import christmas.global.FoodMenu;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputHandler {

    public static void outputEventPlanner(EventPlanner eventPlanner) {
        String outputBenefitInformation = makeBenefitInformationMessage(eventPlanner);
        OutputView.printWithBlankLine(outputBenefitInformation);

        outputEventPlannerResult(eventPlanner);
    }

    private static String makeBenefitInformationMessage(EventPlanner eventPlanner) {
        int day = eventPlanner.getDate().getDayOfMonth();
        return String.format(INPUT_BENEFIT_INFORMATION.getMessage(), day);
    }

    private static void outputEventPlannerResult(EventPlanner eventPlanner) {
        outputOrderMenu(eventPlanner.getOrder());
        outputTotalOrderPriceBeforeDiscount(eventPlanner.getOrderPrice());
        outputGiveAwayMenu(eventPlanner.getGiveAwayProduct());
        outputBenefitDetail(eventPlanner.getBenefits());
        outputTotalBenefitPrice(eventPlanner.getAllDiscountPrice());
        outputPaymentPriceAfterDiscount(eventPlanner.getDiscountedOrderPrice());
        outputDecemberEventBadge(eventPlanner.getEventBadge());
    }

    public static void outputOrderMenu(Order order) {
        OutputView.printMessage(OUTPUT_ORDER_MENU);
        Map<FoodMenu, Integer> foodMenus = order.foodMenus();

        List<String> outputFoodMenus = new ArrayList<>();
        addOutputFoodMenus(foodMenus, outputFoodMenus);

        OutputView.printMessagesWithBlankLine(outputFoodMenus);
    }

    private static void addOutputFoodMenus(Map<FoodMenu, Integer> foodMenus, List<String> outputFoodMenus) {
        for (Entry<FoodMenu, Integer> foodMenu : foodMenus.entrySet()) {
            String outputFoodMenu = setFoodMenuMessage(foodMenu);
            outputFoodMenus.add(outputFoodMenu);
        }
    }

    private static String setFoodMenuMessage(Entry<FoodMenu, Integer> foodMenu) {
        String foodName = foodMenu.getKey().getName();
        Integer foodCount = foodMenu.getValue();

        return setMenuNameAndCountMessage(foodName, foodCount);
    }

    public static void outputTotalOrderPriceBeforeDiscount(int OrderPrice) {
        OutputView.printMessage(OUTPUT_TOTAL_ORDER_PRICE_BEFORE_DISCOUNT);

        String outputOrderPrice = priceToString(OrderPrice);
        OutputView.printWithBlankLine(outputOrderPrice);
    }


    public static void outputGiveAwayMenu(GiveAwayProduct giveAwayProduct) {
        OutputView.printMessage(OUTPUT_GIVE_AWAY_MENU);

        if (giveAwayProduct == null) {
            OutputView.printMessageWithBlankLine(OUTPUT_NOTHING);
            return;
        }
        String outputGiveAwayProduct = setGiveAwayProductMessage(giveAwayProduct);
        OutputView.printWithBlankLine(outputGiveAwayProduct);
    }

    private static String setGiveAwayProductMessage(GiveAwayProduct giveAwayProduct) {
        String giveAwayProductName = giveAwayProduct.product().getName();
        int giveAwayProductCount = giveAwayProduct.count();

        return setMenuNameAndCountMessage(giveAwayProductName, giveAwayProductCount);
    }


    public static void outputBenefitDetail(Map<BenefitDetail, Benefit> benefits) {
        OutputView.printMessage(OUTPUT_BENEFIT_DETAIL);
        List<String> outputBenefits = new ArrayList<>();

        if (benefits.isEmpty()) {
            OutputView.printMessageWithBlankLine(OUTPUT_NOTHING);
            return;
        }
        outputBenefits(benefits, outputBenefits);
    }

    private static void outputBenefits(Map<BenefitDetail, Benefit> benefits, List<String> outputBenefits) {
        for (Entry<BenefitDetail, Benefit> benefit : benefits.entrySet()) {
            addOutputBenefit(benefit, outputBenefits);
        }
        if (outputBenefits.isEmpty()) {
            OutputView.printMessageWithBlankLine(OUTPUT_NOTHING);
            return;
        }
        OutputView.printMessagesWithBlankLine(outputBenefits);
    }

    private static void addOutputBenefit(Entry<BenefitDetail, Benefit> benefit, List<String> outputBenefits) {
        String benefitName = benefit.getKey().getName();
        int benefitPrice = benefit.getValue().getBenefitPrice();

        if (benefitPrice != 0) {
            String outputBenefitPrice = priceToString(benefitPrice);
            String outputBenefit = setBenefitMessage(benefitName, outputBenefitPrice);
            outputBenefits.add(outputBenefit);
        }
    }


    public static void outputTotalBenefitPrice(int totalBenefitPrice) {
        OutputView.printMessage(OUTPUT_TOTAL_BENEFIT_PRICE);
        String outputBenefitPrice = priceToString(totalBenefitPrice);

        if (totalBenefitPrice == 0) {
            OutputView.printWithBlankLine(outputBenefitPrice);
            return;
        }
        OutputView.printWithBlankLine(setMinusPriceMessage(outputBenefitPrice));
    }



    public static void outputPaymentPriceAfterDiscount(int discountedOrderPrice) {
        OutputView.printMessage(OUTPUT_PAYMENT_PRICE_AFTER_DISCOUNT);
        String outputDisCountedOrderPrice = priceToString(discountedOrderPrice);
        OutputView.printWithBlankLine(outputDisCountedOrderPrice);
    }

    public static void outputDecemberEventBadge(EventBadge badge) {
        OutputView.printMessage(OUTPUT_DECEMBER_EVENT_BADGE);
        OutputView.printWithBlankLine(badge.getName());
    }
}
