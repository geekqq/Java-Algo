package Day263;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime now1 = LocalTime.parse("09:30");
        System.out.println(now1);

        LocalTime now2 = LocalTime.of(9, 45);
        System.out.println(now2);
        LocalTime now3 = now2.plus(1, ChronoUnit.HOURS);
        System.out.println(now3);
        boolean isBefore = LocalTime.parse("09:30").isBefore(LocalTime.parse("09:45"));
        System.out.println(isBefore);
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.NOON);
        System.out.println("===============");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(localDateTime1);
    }
}
