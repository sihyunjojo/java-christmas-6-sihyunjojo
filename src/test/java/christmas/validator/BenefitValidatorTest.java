package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BenefitValidatorTest {
    @DisplayName("DDayDiscountValid 메서드 Ture 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2023-12-01","2023-12-15","2023-12-25"})
    void testDDayDiscountValid(String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        
        assertTrue(BenefitValidator.isDDayDiscountValid(date));
    }

    @DisplayName("DDayDiscountValid 메서드 False 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2023-11-30","2023-12-26","2023-12-31"})
    void testDDayDiscountValidInInvalid(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        assertFalse(BenefitValidator.isDDayDiscountValid(date));
    }


    @DisplayName("SpecialDiscountValid 메서드 True 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2023-12-03","2023-12-10","2023-12-17","2023-12-24","2023-12-25","2023-12-31"})
    void testSpecialDiscountValid(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        assertTrue(BenefitValidator.isSpecialDiscountValid(date));
    }

    @DisplayName("SpecialDiscountValid 메서드 False 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2023-11-30","2023-12-26","2023-12-30"})
    void testSpecialDiscountValidInInvalid(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        assertFalse(BenefitValidator.isSpecialDiscountValid(date));
    }

    @DisplayName("WeekendDiscountValid 메서드 True 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2023-12-02","2023-12-03","2023-12-23","2023-12-30","2023-12-31"})
    void testWeekendDiscountValid(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        assertTrue(BenefitValidator.isWeekendDiscountValid(date));
    }

    @DisplayName("WeekendDiscountValid 메서드 False 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2023-12-01","2023-12-13","2023-12-29"})
    void testWeekendDiscountValidInInvalid(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        assertFalse(BenefitValidator.isWeekendDiscountValid(date));
    }

    @DisplayName("WeekdayDiscountValid 메서드 True 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2023-12-01","2023-12-13","2023-12-29"})
    void testWeekdayDiscountValid(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        assertTrue(BenefitValidator.isWeekdayDiscountValid(date));
    }

    @DisplayName("WeekdayDiscountValid 메서드 False 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2023-12-02","2023-12-03","2023-12-23","2023-12-30","2023-12-31"})
    void testWeekdayDiscountValidInInvalid(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        assertFalse(BenefitValidator.isWeekdayDiscountValid(date));
    }

    @DisplayName("GiveAwayEventValid 메서드 True 테스트")
    @ParameterizedTest
    @ValueSource(ints = {120000,200000,1000000})
    void testGiveAwayEventValid(int orderPrice) {
        assertTrue(BenefitValidator.isGiveAwayEventValid(orderPrice));
    }

    @DisplayName("GiveAwayEventValid 메서드 False 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0,1000,10000,100000})
    void testGiveAwayEventValidInInvalid(int orderPrice) {
        assertFalse(BenefitValidator.isGiveAwayEventValid(orderPrice));
    }
}