package christmas.validator;

import christmas.exception.InvalidInputException;

public class InputValidator {
    public static void validateInputStringParseInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new InvalidInputException();
        }
    }
}
