package christmas.domain.event.discount;

import static christmas.global.constants.DisCountPriceConstants.SPECIAL_DISCOUNT_PRICE;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialDiscountTest {

    @DisplayName("SpecialDiscount 객체를 생성해준다.")
    @ValueSource(ints = {3, 25, 31})
    @ParameterizedTest
    void testValidInputCreateSpecialDiscount(int day) {
        Assertions.assertEquals(SpecialDiscount.createSpecialDiscount(),
                new SpecialDiscount());
    }

    @DisplayName("전체주문가격이 들어오면 특별할인가격만큼 깍은 가격을 반환해준다.")
    @CsvSource(value = {"3,10000","25,20000","31,1000000"},delimiter = ',')
    @ParameterizedTest
    void testDiscountAllOrderPrice(int day, int orderPrice) {
        LocalDate inputDate = LocalDate.of(2023, 12, day);
        SpecialDiscount specialDiscount = SpecialDiscount.createSpecialDiscount();

        Assertions.assertEquals(specialDiscount.discountOrderPrice(orderPrice),orderPrice- SPECIAL_DISCOUNT_PRICE);
    }
}