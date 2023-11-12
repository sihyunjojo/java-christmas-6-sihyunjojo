package christmas.domain.event.discount;

import static christmas.global.constants.DisCountPriceConstants.SPECIAL_DISCOUNT_PRICE;
import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.InvalidDateException;
import christmas.global.constants.DisCountPriceConstants;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialDiscountTest {

    @DisplayName("적절한 날(day)이 들어오면 SpecialDiscount 객체를 생성해준다.")
    @ValueSource(ints = {3, 25, 31})
    @ParameterizedTest
    void testValidInputCreateSpecialDiscount(int day) {
        LocalDate inputDate = LocalDate.of(2023, 12, day);

        Assertions.assertEquals(SpecialDiscount.createSpecialDiscount(inputDate),
                new SpecialDiscount());
    }

    @DisplayName("부적절한 날(day)이 들어오면 예외를 발생시켜준다.")
    @ValueSource(ints = {1, 20, 30})
    @ParameterizedTest
    void testInvalidInputCreateSpecialDiscount(int day) {
        LocalDate inputDate = LocalDate.of(2023, 12, day);

        Assertions.assertThrows(InvalidDateException.class, () -> SpecialDiscount.createSpecialDiscount(inputDate));
    }

    @DisplayName("전체주문가격이 들어오면 특별할인가격만큼 깍은 가격을 반환해준다.")
    @CsvSource(value = {"3,10000","25,20000","31,1000000"},delimiter = ',')
    @ParameterizedTest
    void testDiscountAllOrderPrice(int day, int orderPrice) {
        LocalDate inputDate = LocalDate.of(2023, 12, day);
        SpecialDiscount specialDiscount = SpecialDiscount.createSpecialDiscount(inputDate);

        Assertions.assertEquals(specialDiscount.discountAllOrderPrice(orderPrice),orderPrice- SPECIAL_DISCOUNT_PRICE);
    }
}