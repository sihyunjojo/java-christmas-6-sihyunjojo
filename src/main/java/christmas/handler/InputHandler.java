package christmas.handler;

import static christmas.message.SystemMessage.*;
import static christmas.validator.InputFoodMenusValidator.*;

import christmas.global.FoodMenu;
import christmas.util.InputUtil;
import christmas.validator.InputDateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.time.LocalDate;
import java.util.Map;

public class InputHandler {
    public static LocalDate setDate(){
        OutputView.printMessage(INPUT_DAY);

        String inputDay = InputView.read();
        InputDateValidator.validateStringDateParseInteger(inputDay);

        int day = InputUtil.StringToInt(inputDay);
        InputDateValidator.validateInputDayPeriod(day);

        return LocalDate.of(2023, 12, day);
    }

    public static Map<FoodMenu, Integer> setFoodMenus(){
        OutputView.printMessage(INPUT_FOOD_MENUS);

        String inputFoodMenus = InputView.read();
        String[] splitFoodMenus = InputUtil.splitStringByComma(inputFoodMenus);
        validateSplitFoodMenus(splitFoodMenus);

        Map<FoodMenu, Integer> foodMenus = InputUtil.StringsToFoodMenus(splitFoodMenus);
        validateInputFoodMenuCount(foodMenus);

        return foodMenus;
    }
}
