package Day263;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class PeriodAndDurationDemo {

    public static void main(String[] args) {
        LocalDate initialDate = LocalDate.now();
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        System.out.println(finalDate);
        System.out.println(Period.between(initialDate, finalDate).getDays());
        System.out.println("============");
        long between = ChronoUnit.DAYS.between(initialDate, finalDate);
        System.out.println(between);

        LocalTime initialTime = LocalTime.of(6, 20,0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        long du = Duration.between(initialTime, finalTime).getSeconds();
        System.out.println(du);

        long between1 = ChronoUnit.SECONDS.between(initialTime, finalTime);
        System.out.println(between1);
        System.out.println(Instant.now());
    }
}
