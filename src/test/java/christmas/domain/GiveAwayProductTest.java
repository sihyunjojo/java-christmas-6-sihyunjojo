package christmas.domain;

import static christmas.domain.GiveAwayProduct.createGiveAwayProduct;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.event.GiveAwayEvent;
import christmas.global.FoodMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GiveAwayProductTest {
    @DisplayName("상품과 갯수가 들어오면 GiveAwayProduct 객체를 생성해준다.")
    @CsvSource(value = {"CHAMPAGNE, 1","ZERO_COLA, 2"},delimiter = ',')
    @ParameterizedTest
    void testCreateGiveAwayProduct(String foodMenu, int count) {
        GiveAwayProduct giveAwayProduct = createGiveAwayProduct(FoodMenu.valueOf(foodMenu), count);

        Assertions.assertEquals(giveAwayProduct, new GiveAwayProduct(FoodMenu.valueOf(foodMenu), count));

    }
}