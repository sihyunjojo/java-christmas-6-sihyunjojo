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
        int day = eventPlanner.getDate().getDayOfMonth();
        String outputBenefitInformation = String.format(INPUT_BENEFIT_INFORMATION.getMessage(), day);
        OutputView.printWithBlankLine(outputBenefitInformation);

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

        for (Entry<FoodMenu, Integer> foodMenu : foodMenus.entrySet()) {
            String foodName = foodMenu.getKey().getName();
            Integer foodCount = foodMenu.getValue();

            String outputFoodMenu = foodName + " " + foodCount + "개";
            outputFoodMenus.add(outputFoodMenu);
        }

        OutputView.printMessagesWithBlankLine(outputFoodMenus);
    }

    public static void outputTotalOrderPriceBeforeDiscount(int OrderPrice) {
        OutputView.printMessage(OUTPUT_TOTAL_ORDER_PRICE_BEFORE_DISCOUNT);

        String outputOrderPrice = priceToString(OrderPrice);
        OutputView.printWithBlankLine(outputOrderPrice);
    }



    public static void outputGiveAwayMenu(GiveAwayProduct giveAwayProduct) {
        OutputView.printMessage(OUTPUT_GIVE_AWAY_MENU);

        if (giveAwayProduct != null) {
            String giveAwayProductName = giveAwayProduct.product().getName();
            int giveAwayProductCount = giveAwayProduct.count();

            String outputGiveAwayProduct = giveAwayProductName + " " + giveAwayProductCount + "개";
            OutputView.printWithBlankLine(outputGiveAwayProduct);
            return;
        }
        OutputView.printWithBlankLine("없음");
    }

    public static void outputBenefitDetail(Map<BenefitDetail, Benefit> benefits) {
        OutputView.printMessage(OUTPUT_BENEFIT_DETAIL);

        if (!benefits.isEmpty()) {
            List<String> outputBenefits = new ArrayList<>();
            for (Entry<BenefitDetail, Benefit> benefit : benefits.entrySet()) {
                String benefitName = benefit.getKey().getName();
                int benefitPrice = benefit.getValue().getBenefitPrice();

                String outputBenefitPrice = priceToString(benefitPrice);
                String outputBenefit = benefitName + ": -" + outputBenefitPrice;
                outputBenefits.add(outputBenefit);
            }

            OutputView.printMessagesWithBlankLine(outputBenefits);
            return;
        }

        OutputView.printWithBlankLine("없음");

    }

    public static void outputTotalBenefitPrice(int totalBenefitPrice) {
        OutputView.printMessage(OUTPUT_TOTAL_BENEFIT_PRICE);
        if (totalBenefitPrice != 0) {
            String outputBenefitPrice = priceToString(totalBenefitPrice);
            OutputView.printWithBlankLine("-" + outputBenefitPrice);
            return;
        }
        OutputView.printWithBlankLine("0원");
    }

    public static void outputPaymentPriceAfterDiscount(int discountedOrderPrice) {
        OutputView.printMessage(OUTPUT_PAYMENT_PRICE_AFTER_DISCOUNT);

        if (discountedOrderPrice != 0) {
            String outputDisCountedOrderPrice = priceToString(discountedOrderPrice);
            OutputView.printWithBlankLine(outputDisCountedOrderPrice);
            return;
        }
        OutputView.printWithBlankLine("0원");

    }

    public static void outputDecemberEventBadge(EventBadge badge) {
        OutputView.printMessage(OUTPUT_DECEMBER_EVENT_BADGE);

        OutputView.printWithBlankLine(badge.getName());
    }
}
