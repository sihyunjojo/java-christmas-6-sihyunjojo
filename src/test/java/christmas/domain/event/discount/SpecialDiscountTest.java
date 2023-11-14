package christmas.domain.event.discount;

import static christmas.global.constants.DisCountPriceConstants.SPECIAL_DISCOUNT_PRICE;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialDiscountTest {

    @DisplayName("SpecialDiscount 객체를 생성해준다.")
    @ValueSource(ints = {3, 25, 31})
    @ParameterizedTest
    void testValidInputCreateSpecialDiscount(int day) {
        Assertions.assertEquals(SpecialDiscount.createSpecialDiscount(),
                new SpecialDiscount());
    }

}