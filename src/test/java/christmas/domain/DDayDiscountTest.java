package christmas.domain;

import christmas.domain.event.discount.DDayDiscount;
import christmas.exception.InvalidDateException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DDayDiscountTest {

    @DisplayName("적절한 날(day)이 들어오면 DDayDisCount 객체를 생성해준다.")
    @ValueSource(ints = {1, 25})
    @ParameterizedTest
    void testValidInputCreateDDayDiscount(int day) {
        LocalDate inputDate = LocalDate.of(2023, 12, day);

        Assertions.assertEquals(DDayDiscount.createDDayDiscount(day),
                new DDayDiscount(inputDate));
    }

    @DisplayName("부적절한 날(day)이 들어오면 예외를 발생시켜준다.")
    @ValueSource(ints = {26, 31})
    @ParameterizedTest
    void testInvalidInputCreateDDayDiscount(int day) {
        Assertions.assertThrows(InvalidDateException.class, () -> DDayDiscount.createDDayDiscount(day));
    }

    @DisplayName("현재 할인 가격을 얻어오면 옳은 값을 가져온다.")
    @CsvSource(value = {"1:1000","2:1100","20:2900","25:3400"},delimiter = ':')
    @ParameterizedTest
    void testGetCurrentDiscountPrice(int day, int discountPrice) {
        Assertions.assertEquals(DDayDiscount.createDDayDiscount(day).getCurrentDiscountPrice(),
                discountPrice);
    }
}