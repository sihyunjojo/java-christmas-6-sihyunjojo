package christmas.domain.event;

import static christmas.domain.GiveAwayProduct.createGiveAwayProduct;
import static christmas.global.FoodMenu.*;
import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.InvalidDateException;
import christmas.global.FoodMenu;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GiveAwayEventTest {
    @DisplayName("적절한 날(day)이 들어오면 GiveAwayEvent 객체를 생성해준다.")
    @CsvSource(value = {"CHAMPAGNE, 1","ZERO_COLA, 2"},delimiter = ',')
    @ParameterizedTest
    void testValidInputCreateGiveAwayEvent(String foodMenu, int count) {
        Assertions.assertEquals(GiveAwayEvent.createGiveAwayEvent(createGiveAwayProduct(FoodMenu.valueOf(foodMenu), count)),
                new GiveAwayEvent(createGiveAwayProduct(FoodMenu.valueOf(foodMenu), count)));
    }

}