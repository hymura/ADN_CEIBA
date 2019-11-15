package co.com.ceiba.oc.dominio.validation;

import java.time.LocalDateTime;
import java.time.DayOfWeek;

public class GenericValidation {
	

    public static void requireDateGreater(LocalDateTime date1, LocalDateTime date2, String message) {
        if (!date2.isAfter(date1)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void requireNotWeekend(LocalDateTime date, String message) {
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void requireDifferentDay(LocalDateTime date1, LocalDateTime date2, String message) {
        if (date1.toLocalDate().isEqual(date2.toLocalDate())) {
            throw new IllegalArgumentException(message);
        }
    }

}
