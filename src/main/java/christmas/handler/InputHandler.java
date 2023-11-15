package christmas.handler;

import static christmas.global.constants.DiscountDateConstants.*;
import static christmas.message.SystemMessage.*;
import static christmas.validator.InputFoodMenusValidator.*;

import christmas.domain.Order;
import christmas.global.FoodMenu;
import christmas.message.ErrorMessage;
import christmas.util.InputUtil;
import christmas.validator.EventValidator;
import christmas.validator.InputDateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.time.LocalDate;
import java.util.Map;

public class InputHandler {
    public static LocalDate setDate(){
        OutputView.printMessage(INPUT_DAY);
//        while (true) {
            try {
                return inputDate();
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(ErrorMessage.INVALID_DATE);
            }
//        }
        return null;
    }

    private static LocalDate inputDate() {
        String inputDay = InputView.read();
        InputDateValidator.validateStringDateParseInteger(inputDay);

        int day = InputUtil.StringToInt(inputDay);
        InputDateValidator.validateInputDayPeriod(day);

        LocalDate date = LocalDate.of(DISCOUNT_EVENT_YEAR, DISCOUNT_EVENT_MONTH, day);
        EventValidator.validateDisCountPeriod(date);
        return date;
    }

    public static Order setOrder(){
        OutputView.printMessage(INPUT_FOOD_MENUS);
//        while (true) {
            try {
                return createOrder(inputFoodMenus());
            }
            catch (IllegalArgumentException e) {
                OutputView.printMessage(ErrorMessage.INVALID_ORDER);
            }
//        }
        return createOrder(inputFoodMenus());
    }

    private static Order createOrder(Map<FoodMenu, Integer> foodMenus) {
        Order order = Order.createOrder(foodMenus);
        EventValidator.validateOrderFoodCategory(order.getFoodMenus());
        EventValidator.validateOrderFoodMenuCount(order.getFoodMenuCount());
        return order;
    }

    private static Map<FoodMenu, Integer> inputFoodMenus() {
        String inputFoodMenus = InputView.read();

        String[] splitFoodMenus = InputUtil.splitStringByComma(inputFoodMenus);
        validateSplitFoodMenus(splitFoodMenus);

        Map<FoodMenu, Integer> foodMenus = InputUtil.StringsToFoodMenus(splitFoodMenus);
        validateInputFoodMenuCount(foodMenus);
        return foodMenus;
    }
}