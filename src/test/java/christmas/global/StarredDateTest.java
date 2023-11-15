//package christmas.global;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.time.LocalDate;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//
//class StarredDateTest {
//    @ParameterizedTest
//    @ValueSource(ints = {3, 10, 25, 31})
//    @DisplayName("달력에 별표시 된 날짜가 들어오면 true를 반환해준다.")
//    void testIsStarredDateInValidDate(int day) {
//        LocalDate date = LocalDate.of(2023, 12, day);
//
//        assertTrue(StarredDate.isStarredDate(date));
//    }
//    @ParameterizedTest
//    @CsvSource(value = {"2023:12:1","2023:12:30","2024:01:01"}, delimiter = ':')
//    @DisplayName("달력에 별표시 안된 날짜가 들어오면 False를 반환해준다.")
//    void testIsStarredDateInInvalidDate(int year,int month, int day) {
//        LocalDate date = LocalDate.of(year, month, day);
//
//        assertFalse(StarredDate.isStarredDate(date));
//    }
//
//}