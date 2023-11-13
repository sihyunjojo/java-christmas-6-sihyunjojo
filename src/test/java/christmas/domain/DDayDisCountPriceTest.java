package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.event.discount.DDayDiscount;
import christmas.exception.InvalidDateException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DDayDisCountPriceTest {

    @DisplayName("디데이 할인기간과 함께 DDAyDisCountPrice 객체를 만들어준다.")
    @CsvSource(value = {"1:1000", "2:1100", "20:2900", "25:3400"}, delimiter = ':')
    @ParameterizedTest
    void testCreateDDayDisCountPrice(int day, int discountPrice) {
        LocalDate inputDate = LocalDate.of(2023, 12, day);

        Assertions.assertEquals(DDayDisCountPrice.createDDayDisCountPrice(inputDate),
                new DDayDisCountPrice(discountPrice));
    }

    @DisplayName("잘못된 날짜를 입력받으면 예외를 발생시켜준다.")
    @ValueSource(ints = {26, 31})
    @ParameterizedTest
    void testInvalidDateUpdateDDayDisCountPrice(int day) {
        LocalDate inputDate = LocalDate.of(2023, 12, day);

        assertThrows(InvalidDateException.class,
                () -> DDayDisCountPrice.updateDDayDisCountPrice(inputDate));
    }

    @DisplayName("총 가격을 입력하면 할인 된 가격을 알려준다.")
    @CsvSource(value = {"10,10000", "20,20000"}, delimiter = ',')
    @ParameterizedTest
    void testDiscountOrderPrice(int day, int orderPrice) {
        LocalDate date = LocalDate.of(2023, 12, day);
        DDayDiscount dDayDiscount = DDayDiscount.createDDayDiscount(date);

        assertEquals(dDayDiscount.discountOrderPrice(orderPrice), orderPrice - dDayDiscount.getDiscountPrice());
    }

    @DisplayName("적절한 날짜를 입력받으면 그 날짜에 대한 디데이 할인 가격이 나온다.")
    @CsvSource(value = {"1:1000", "2:1100", "20:2900", "25:3400"}, delimiter = ':')
    @ParameterizedTest
    void testUpdateDDayDisCountPrice(int day, int discountPrice) {

        LocalDate inputDate = LocalDate.of(2023, 12, day);

        Assertions.assertEquals(DDayDisCountPrice.updateDDayDisCountPrice(inputDate),
                discountPrice);
    }



}