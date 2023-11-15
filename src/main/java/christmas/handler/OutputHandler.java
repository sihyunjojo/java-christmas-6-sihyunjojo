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

    public static void outputTotalOrderPriceBeforeDiscount(int orderPrice) {
        OutputView.printMessage(OUTPUT_TOTAL_ORDER_PRICE_BEFORE_DISCOUNT);

        OutputView.printWithBlankLine(setMessage(OUTPUT_PRICE_MESSAGE, orderPrice));
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

    public static void outputBenefitDetail(Map<BenefitDetail, Benefit> benefits) {
        OutputView.printMessage(OUTPUT_BENEFIT_DETAIL);
        List<String> outputBenefits = new ArrayList<>();

        if (benefits.isEmpty()) {
            OutputView.printMessageWithBlankLine(OUTPUT_NOTHING);
            return;
        }
        setOutputBenefits(benefits, outputBenefits);
        outputBenefits(outputBenefits);
    }

    private static void outputBenefits(List<String> outputBenefits) {
        if (outputBenefits.isEmpty()) {
            OutputView.printMessageWithBlankLine(OUTPUT_NOTHING);
            return;
        }
        OutputView.printMessagesWithBlankLine(outputBenefits);
    }

    private static void setOutputBenefits(Map<BenefitDetail, Benefit> benefits, List<String> outputBenefits) {
        for (Entry<BenefitDetail, Benefit> benefit : benefits.entrySet()) {
            addOutputBenefit(benefit, outputBenefits);
        }
    }

    private static void addOutputBenefit(Entry<BenefitDetail, Benefit> benefit, List<String> outputBenefits) {
        String benefitName = benefit.getKey().getName();
        int benefitPrice = benefit.getValue().getBenefitPrice();

        if (benefitPrice != 0) {
            String outputBenefit = setMessage(OUTPUT_BENEFIT_MESSAGE,benefitName,benefitPrice);
            outputBenefits.add(outputBenefit);
        }
    }


    public static void outputTotalBenefitPrice(int totalBenefitPrice) {
        OutputView.printMessage(OUTPUT_TOTAL_BENEFIT_PRICE);

        if (totalBenefitPrice == 0) {
            OutputView.printWithBlankLine(setMessage(OUTPUT_PRICE_MESSAGE, totalBenefitPrice));
            return;
        }
        OutputView.printWithBlankLine(setMessage(OUTPUT_MINUS_PRICE_MESSAGE, totalBenefitPrice));
    }



    public static void outputPaymentPriceAfterDiscount(int discountedOrderPrice) {
        OutputView.printMessage(OUTPUT_PAYMENT_PRICE_AFTER_DISCOUNT);
        String outputDisCountedOrderPrice = setMessage(OUTPUT_PRICE_MESSAGE, discountedOrderPrice);
        OutputView.printWithBlankLine(outputDisCountedOrderPrice);
    }

    public static void outputDecemberEventBadge(EventBadge badge) {
        OutputView.printMessage(OUTPUT_DECEMBER_EVENT_BADGE);
        OutputView.print(badge.getName());
    }
}
