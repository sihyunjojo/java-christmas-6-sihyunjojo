///*
//package christmas.util;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import christmas.global.FoodMenu;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//class UtilTest {
//    @ParameterizedTest
//    @ValueSource(strings = {"티본스테이크", "바비큐립", "초코케이크"})
//    @DisplayName("findFoodMenuByName에 존재하는 메뉴를 넣으면, 그 메뉴를 반환해준다.")
//    void testFindFoodMenuByName(String menuName) {
//        FoodMenu foundMenu = Util.findFoodMenuByName(menuName);
//
//        assert foundMenu != null;
//        assertNotNull(foundMenu.getName());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"존재하지않는메뉴", "라면", "피자"})
//    @DisplayName("findFoodMenuByName에 존재하지 않는 메뉴를 넣으면, null을 반환해준다.")
//    void testFindFoodMenuByName_invalidMenu(String menuName) {
//        FoodMenu foundMenu = Util.findFoodMenuByName(menuName);
//
//        assertNull(foundMenu);
//    }
//}*/
