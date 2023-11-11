package christmas.global;

import java.time.LocalDate;

public enum StarredDate {
    DECEMBER_3(LocalDate.of(2023, 12, 3)),
    DECEMBER_10(LocalDate.of(2023, 12, 10)),
    DECEMBER_17(LocalDate.of(2023, 12, 17)),
    DECEMBER_24(LocalDate.of(2023, 12, 24)),
    DECEMBER_25(LocalDate.of(2023, 12, 25)),
    DECEMBER_31(LocalDate.of(2023, 12, 31));

    private final LocalDate localDate;

    StarredDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
