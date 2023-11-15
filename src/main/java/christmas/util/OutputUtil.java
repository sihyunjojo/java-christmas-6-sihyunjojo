package christmas.util;

import christmas.domain.Benefit;

public class OutputUtil {
    public static String priceToString(int orderPrice) {
        return String.format("%,d원", orderPrice);
    }
    public static String setMenuNameAndCountMessage(String MenuName, int count) {
        return MenuName + " " + count + "개";
    }
    public static String setBenefitMessage(String benefitName, String outputBenefitPrice) {
        return benefitName + ": -" + outputBenefitPrice;
    }
    public static String setMinusPriceMessage(String outputBenefitPrice) {
        return "-" + outputBenefitPrice;
    }

}
