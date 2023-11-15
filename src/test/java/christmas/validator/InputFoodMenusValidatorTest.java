package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.InvalidInputException;
import christmas.exception.InvalidOrderException;
import christmas.global.FoodMenu;
import christmas.util.Util;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputFoodMenusValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"티본스테이크,1","제로콜라,2","샴페인,3"})
    @DisplayName("메뉴 안에 있는 메뉴와 숫자인 개수가 들어가면, 예외를 일으키지 않는다.")
    void testValidateFoodMenus(String menuName, String count) {
        assertDoesNotThrow(() -> InputFoodMenusValidator.validateFoodMenus(menuName, count));
    }

    @ParameterizedTest
    @CsvSource(value = {"라면,1","감자,2","까르보나라,3"})
    @DisplayName("메뉴 안에 없는 메뉴와 숫자인 개수가 들어가면, 예외를 일으킨다.")
    void testInvalidateFoodMenusInvalidateMenu(String menuName, String count) {
        assertThrows(InvalidOrderException.class,
                () -> InputFoodMenusValidator.validateFoodMenus(menuName, count));
    }
    @ParameterizedTest
    @CsvSource(value = {"티본스테이크,abc","제로콜라,제로콜라"})
    @DisplayName("메뉴 안에 있는 메뉴와 숫자가 아닌 개수가 들어가면, 예외를 일으킨다.")
    void testInvalidateFoodMenusInvalidateCount(String menuName, String count) {
        assertThrows(InvalidOrderException.class,
                () -> InputFoodMenusValidator.validateFoodMenus(menuName, count));
    }
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크", "제로콜라", "초코케이크"})
    @DisplayName("메뉴 안에 있느 메뉴가 들어가면, 예외를 일으키지 않는다.")
    void testValidateFoodMenus(String menuName) {
        assertDoesNotThrow(() -> InputFoodMenusValidator.validateInputMenuInFoodMenu(menuName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"라면", "감자", "까르보나라", "존재하지않는메뉴"})
    @DisplayName("메뉴 안에 없는 메뉴가 들어가면, 예외를 일으킨다.")
    void testValidateFoodMenusByInvalidateMenu(String menuName) {
        assertThrows(InvalidOrderException.class,
                () -> InputFoodMenusValidator.validateInputMenuInFoodMenu(menuName));
    }

    @Test
    @DisplayName("음식의 개수가 1개 이상이면, 예외를 일으키지 않는다.")
    void testValidateInputFoodMenuCount() {
        Map<FoodMenu, Integer> validFoodMenus = new HashMap<>();
        validFoodMenus.put(FoodMenu.T_BONE_STEAK, 2);
        validFoodMenus.put(FoodMenu.BBQ_RIBS, 1);

        assertDoesNotThrow(() -> InputFoodMenusValidator.validateInputFoodMenuCount(validFoodMenus));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    @DisplayName("음식의 개수가 1개 미만이면, 예외를 일으킨다.")
    void testValidateInputFoodMenuCountByInvalidCount(int invalidCount) {
        Map<FoodMenu, Integer> FoodMenus = new HashMap<>();
        FoodMenus.put(FoodMenu.BBQ_RIBS, invalidCount);

        assertThrows(InvalidOrderException.class,
                () -> InputFoodMenusValidator.validateInputFoodMenuCount(FoodMenus));
    }

    @ParameterizedTest
    @CsvSource(value = {"티본스테이크-2,바비큐립-1", "타파스-1,제로콜라-2"},delimiter = ',')
    @DisplayName("배열 안의 원소가 모두 Bar로 나누어져있으면, 예외를 일으키지 않는다.")
    void testValidateSplitFoodMenus(String input1, String input2) {
        String[] input = {input1, input2};

        assertDoesNotThrow(() -> InputFoodMenusValidator.validateSplitFoodMenus(input));
    }
    @ParameterizedTest
    @CsvSource(value = {"티본스테이크_2, 바비큐립-1", "타파스~1, 제로콜라,2"},delimiter = ',')
    @DisplayName("배열 안의 원소가 하나라도 Bar로 나누어져 있지 않으면, 예외를 일으킨다.")
    void testValidateSplitFoodMenusByNotBar(String input1, String input2) {
        String[] input = {input1, input2};

        assertThrows(InvalidInputException.class, () -> InputFoodMenusValidator.validateSplitFoodMenus(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-2", "바베큐립-1", "제로콜라-2"})
    @DisplayName("입력이 Bar로 나누어져있으면, 예외를 일으키지 않는다.")
    void testValidateInputStringFormatByBar(String input) {
        assertDoesNotThrow(() -> InputFoodMenusValidator.validateInputStringFormatByBar(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크~2", "바베큐립_1", "제로콜라"})
    @DisplayName("입력이 Bar로 나누어져 있지 않으면, 예외를 일으킨다.")
    void testValidateInputStringFormatByCountByNotBar(String input) {
        assertThrows(InvalidInputException.class,() -> InputFoodMenusValidator.validateInputStringFormatByBar(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크", "1", " ",""})
    @DisplayName("입력이 2개로 나누어져 있지 않으면, 예외를 일으킨다.")
    void testValidateInputStringFormatByCountByInvalidInput(String input) {
        String[] splitString = {input};

        assertThrows(InvalidInputException.class, () -> InputFoodMenusValidator.validateInputStringFormatByCount(splitString));
    }
    @ParameterizedTest
    @CsvSource(value = {"티본스테이크,2", "바베큐립,1", "제로콜라,2"})
    @DisplayName("입력이 2개로 나누어져 있으면, 예외를 일으키지 않는다.")
    void testValidateInputStringFormatByCount(String menu, String count){
        String[] splitString = {menu, count};
        assertDoesNotThrow(() -> InputFoodMenusValidator.validateInputStringFormatByCount(splitString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"샴페인","타파스"})
    @DisplayName("메뉴에 중복이 없으면, 예외를 일으키지 않는다.")
    void testValidateInputFoodMenuIncludingDuplicate(String foodMenu) {
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(FoodMenu.T_BONE_STEAK, 2);
        foodMenus.put(FoodMenu.ZERO_COLA, 1);

        assertDoesNotThrow(() -> InputFoodMenusValidator.validateInputFoodMenuIncludingDuplicate(foodMenus, foodMenu));
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크","제로콜라"})
    @DisplayName("메뉴에 중복이 있으면, 예외를 일으킨다.")
    void testValidateInputFoodMenuIncludingDuplicateByInvalidFoodMenu(String foodMenu) {
        Map<FoodMenu, Integer> foodMenus = new HashMap<>();
        foodMenus.put(Util.findFoodMenuByName(foodMenu), 1);

        assertThrows(InvalidOrderException.class, () -> InputFoodMenusValidator.validateInputFoodMenuIncludingDuplicate(foodMenus, foodMenu));
    }
}



