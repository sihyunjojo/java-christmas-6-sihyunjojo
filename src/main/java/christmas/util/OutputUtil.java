package christmas.util;

import christmas.domain.Benefit;

public class OutputUtil {
    public static String priceToString(int OrderPrice) {
        return String.format("%,d원", OrderPrice);
    }

}
