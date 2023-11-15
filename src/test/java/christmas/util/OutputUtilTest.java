package christmas.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OutputUtilTest {
        @ParameterizedTest
    @ValueSource(ints = {0,1000, 10000, 100000})
    @DisplayName("가격에 대해서, 원하는 형태의 메시지가 나와야한다.")
    void testPriceToString(int price) {
            Assertions.assertEquals(OutputUtil.priceToString(price),String.format("%,d원", price));
    }
}