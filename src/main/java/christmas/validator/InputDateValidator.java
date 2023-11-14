package christmas.validator;

import static christmas.global.constants.EventValidateConstants.*;

import christmas.exception.InvalidInputException;

public class InputDateValidator {
    public static void validateInputDayPeriod(int day) {
        if (day < MIN_DAY || MAX_DAY < day) {
            throw new InvalidInputException();
        }
    }
}
