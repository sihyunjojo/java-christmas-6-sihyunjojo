package christmas.domain.event;

import static christmas.domain.GiveAwayProduct.createGiveAwayProduct;


import christmas.domain.GiveAwayProduct;
import christmas.global.FoodMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GiveAwayEventTest {
    @DisplayName("적절한 날(day)이 들어오면 GiveAwayEvent 객체를 생성해준다.")
    @CsvSource(value = {"CHAMPAGNE, 1","ZERO_COLA, 2"},delimiter = ',')
    @ParameterizedTest
    void testValidInputCreateGiveAwayEvent(String foodMenu, int count) {
        GiveAwayProduct giveAwayProduct = createGiveAwayProduct(FoodMenu.valueOf(foodMenu), count);
        GiveAwayEvent giveAwayEvent = GiveAwayEvent.createGiveAwayEvent(giveAwayProduct);

        Assertions.assertEquals(giveAwayEvent, new GiveAwayEvent(giveAwayProduct));
        Assertions.assertEquals(giveAwayEvent.getGiveAwayProduct(), giveAwayProduct);
        Assertions.assertEquals(giveAwayEvent.getGiveawayProductPrice(), giveAwayProduct.product().getPrice());
    }


}