package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputDateValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 32, 100})
    @DisplayName("날짜 기한 밖의 값이 들어오면, 예외를 터뜨려준다.")
    void testInvalidateInputDayPeriod(int day) {
        assertThrows(InvalidInputException.class, () -> InputDateValidator.validateInputDayPeriod(day));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 15, 31})
    @DisplayName("날짜 기한 안의 값이 들어오면, 예외가 일어나지 않는다.")
    void testValidateInputDayPeriod(int day) {
        assertDoesNotThrow(() -> InputDateValidator.validateInputDayPeriod(day));
    }


}
