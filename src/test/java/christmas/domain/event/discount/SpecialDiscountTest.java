package christmas.domain.event.discount;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class SpecialDiscountTest {

    @Test
    @DisplayName("SpecialDiscount 객체를 생성해준다.")
    void testValidInputCreateSpecialDiscount() {
        Assertions.assertEquals(SpecialDiscount.createSpecialDiscount(),
                new SpecialDiscount());
    }

}