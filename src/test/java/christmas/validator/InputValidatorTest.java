package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"123", "12", "1"})
    @DisplayName("숫자로 바꿀 수 있는 값이면, 예외를 터뜨리지 않는다.")
    void testValidateInputStringParseInteger(String input) {
        assertDoesNotThrow(() -> InputValidator.validateInputStringParseInteger(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "-", ""," "})
    @DisplayName("숫자로 바꿀 수 없는 값이면, 예외를 터뜨린다.")
    void testInvalidateInputStringParseInteger(String input) {
        assertThrows(InvalidInputException.class, () -> InputValidator.validateInputStringParseInteger(input));
    }
}