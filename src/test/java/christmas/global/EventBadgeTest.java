package christmas.global;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EventBadgeTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    @DisplayName("총혜택 금액이 5000이하면, EventBadge.no를 반환해준다.")
    void testDetermineEventBadgeCaseNo(int price) {
        Assertions.assertEquals(EventBadge.no, EventBadge.determineEventBadge(price));
    }
    @ParameterizedTest
    @ValueSource(ints = {5000, 5232, 9999})
    @DisplayName("총혜택 금액이 5000이상 10000미만 이면, EventBadge.star를 반환해준다.")
    void testDetermineEventBadgeCaseStar(int price) {
        Assertions.assertEquals(EventBadge.star, EventBadge.determineEventBadge(price));
    }
    @ParameterizedTest
    @ValueSource(ints = {10000, 15000, 19999})
    @DisplayName("총혜택 금액이 10000이상 20000미만 이면, EventBadge.tree를 반환해준다.")
    void testDetermineEventBadgeCaseTree(int price) {
        Assertions.assertEquals(EventBadge.tree, EventBadge.determineEventBadge(price));
    }
    @ParameterizedTest
    @ValueSource(ints = {20000, 99999, 100000})
    @DisplayName("총혜택 금액이 20000이상 이면, EventBadge.santa를 반환해준다.")
    void testDetermineEventBadgeCaseSanta(int price) {
        Assertions.assertEquals(EventBadge.santa, EventBadge.determineEventBadge(price));
    }
}