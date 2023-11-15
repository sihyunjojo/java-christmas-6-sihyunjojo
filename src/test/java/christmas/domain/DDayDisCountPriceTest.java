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

    @DisplayName("적절한 날짜를 입력받으면 그 날짜에 대한 디데이 할인 가격이 나온다.")
    @CsvSource(value = {"1:1000", "2:1100", "20:2900", "25:3400"}, delimiter = ':')
    @ParameterizedTest
    void testUpdateDDayDisCountPrice(int day, int discountPrice) {

        LocalDate inputDate = LocalDate.of(2023, 12, day);

        Assertions.assertEquals(DDayDisCountPrice.updateDDayDisCountPrice(inputDate),
                discountPrice);
    }



}