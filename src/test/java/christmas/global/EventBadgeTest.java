package christmas.global;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EventBadgeTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    @DisplayName("")
    void testDetermineEventBadgeCaseNo(int price) {
        Assertions.assertEquals(EventBadge.no, EventBadge.determineEventBadge(price));
    }
    @ParameterizedTest
    @ValueSource(ints = {5000, 5232, 9999})
    @DisplayName("")
    void testDetermineEventBadgeCaseStar(int price) {
        Assertions.assertEquals(EventBadge.star, EventBadge.determineEventBadge(price));
    }
    @ParameterizedTest
    @ValueSource(ints = {10000, 15000, 19999})
    @DisplayName("")
    void testDetermineEventBadgeCaseTree(int price) {
        Assertions.assertEquals(EventBadge.tree, EventBadge.determineEventBadge(price));
    }
    @ParameterizedTest
    @ValueSource(ints = {20000, 99999, 100000})
    @DisplayName("")
    void testDetermineEventBadgeCaseSanta(int price) {
        Assertions.assertEquals(EventBadge.santa, EventBadge.determineEventBadge(price));
    }
}