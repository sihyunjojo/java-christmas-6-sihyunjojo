package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.InvalidDateException;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DateValidatorTest {

    @DisplayName("디데이 할인기간 이외의 기간은 잘못된 날짜 예외 에러를 발생시켜준다.")
    @CsvSource(value = {"2022:10:10", "2023:12:26", "2024:01:01"}, delimiter = ':')
    @ParameterizedTest
    void testInvalidateDDayDisCountPeriod(int year, int month, int day) {

        // given
        LocalDate inputDate = LocalDate.of(year, month, day);

        // then
        assertThrows(InvalidDateException.class, () -> DateValidator.validateDDayDisCountPeriod(inputDate));
    }
    @DisplayName("디데이 할인기간 이내의 기간이 들어오면 예외가 발생하지 않는다.")
    @ValueSource(ints = {1, 10, 25})
    @ParameterizedTest
    void testValidateDDayDisCountPeriod(int day) {
        // given
        LocalDate inputDate = LocalDate.of(2023, 12, day);

        // then
        assertDoesNotThrow(() -> DateValidator.validateDDayDisCountPeriod(inputDate));
    }


}