import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
        int thisYear = date.getYear();
        LocalDate firstFridayOfYear = LocalDate.of(thisYear - 1, 12, 31).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        BigDecimal gifts = BigDecimal.ZERO;
        BigDecimal ten = new BigDecimal(10);

        LocalDate dt = firstFridayOfYear;
        while (dt.getYear() == thisYear) {
            if (!dt.isBefore(date)) {
                gifts = gifts.add(ten);
            }
            dt = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            dt = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        return gifts;
    }
    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        int thisYear = date.getYear();
        LocalDate firstFridayOfYear = LocalDate.of(thisYear - 1, 12, 31).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        BigDecimal gifts = BigDecimal.ZERO;

        LocalDate dt = firstFridayOfYear;
        while (dt.getYear() == thisYear) {
            if (!dt.isBefore(date)) {
                gifts = gifts.add(new BigDecimal(dt.getDayOfMonth()));
            }
            dt = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            dt = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        return gifts;
    }

}