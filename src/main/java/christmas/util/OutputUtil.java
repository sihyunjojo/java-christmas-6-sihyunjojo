package christmas.util;

import christmas.domain.Benefit;

public class OutputUtil {
    public static String priceToString(int orderPrice) {
        return String.format("%,d원", orderPrice);
    }

}
