//package christmas.util;
//
//import static christmas.util.InputUtil.*;
//import static christmas.util.Util.findFoodMenuByName;
//import static org.junit.jupiter.api.Assertions.*;
//
//import christmas.exception.InvalidOrderException;
//import christmas.global.FoodMenu;
//import java.util.Map;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//class InputUtilTest {
//    @ParameterizedTest
//    @CsvSource(value = {"티본스테이크-2, 바비큐립-1", "타파스-1,제로콜라-2"}, delimiter = ',')
//    @DisplayName("음식메뉴와 음식의 수가 (-)로 분리되어 잘 들어오면, 예외를 일으키지 않는다.")
//    void testStringsToFoodMenus(String input1, String input2) {
//        String[] input = {input1, input2};
//        String menu1 = input1.split("-")[0];
//        String count1 = input1.split("-")[1];
//        String menu2 = input2.split("-")[0];
//        String count2 = input2.split("-")[1];
//
//        Map<FoodMenu, Integer> foodMenus = StringsToFoodMenus(input);
//
//        assertDoesNotThrow(() -> StringsToFoodMenus(input));
//        assertEquals(Integer.parseInt(count1), foodMenus.get(findFoodMenuByName(menu1)));
//        assertEquals(Integer.parseInt(count2), foodMenus.get(findFoodMenuByName(menu2)));
//    }
//
//    @ParameterizedTest
//    @CsvSource(value = {"메뉴에없는음식-2, 바비큐립-1", "타파스-1, 제로사이다-2"}, delimiter = ',')
//    @DisplayName("메뉴가 제대로 들어오지 않으면, 예외를 일으킨다.")
//    void testStringsToFoodMenusByInvalidInput(String input1, String input2) {
//        String[] input = {input1, input2};
//
//        assertThrows(InvalidOrderException.class, () -> StringsToFoodMenus(input));
//    }
//}