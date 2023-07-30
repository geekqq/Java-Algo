package Day263;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class GetTime {
    public static void main(String[] args) {
        System.out.println(Instant.now());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.println("---------------");
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localDateTime);

        Clock clock = Clock.systemDefaultZone();
        LocalDate localDate1 = LocalDate.now(clock);
        System.out.println(localDate1);
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDate2 = LocalDateTime.now(zoneId);
        System.out.println(localDate2);
        System.out.println("==========================");
        LocalDate localDate3 = LocalDate.of(2023, 07, 29);
        System.out.println(localDate3);
        System.out.println("==========================");
        LocalDate localDate4 = LocalDate.parse("2023-07-29");
        System.out.println(localDate4);
        LocalDate localDate5 = localDate4.plusDays(3);
        System.out.println(localDate5);
        LocalDate localDate6 = localDate4.minusDays(2);
        System.out.println(localDate6);
        LocalDate localDate7 = localDate4.minus(2, ChronoUnit.DAYS);
        System.out.println(localDate7);
        System.out.println("==========================");
        DayOfWeek dayOfWeek = LocalDate.parse("2023-07-29").getDayOfWeek();
        System.out.println(dayOfWeek);
        int dayOfMonth = LocalDate.parse("2023-07-29").getDayOfMonth();
        System.out.println(dayOfMonth);
        boolean isLeapYear = LocalDate.now().isLeapYear();
        boolean isLeapYear2 = LocalDate.now().plusYears(1).isLeapYear();
        System.out.println(isLeapYear);
        System.out.println(isLeapYear2);
        boolean isBefore = LocalDate.parse("2023-07-29").isBefore(LocalDate.parse("2023-07-01"));
        boolean isAfter = LocalDate.parse("2023-07-29").isAfter(LocalDate.parse("2023-07-01"));
        System.out.println(isBefore);
        System.out.println(isAfter);
        System.out.println("==========================");
        LocalDateTime atStartOfDay =LocalDate.parse("2023-07-29").atStartOfDay();
        System.out.println(atStartOfDay);
        LocalDate startDayWith = LocalDate.parse("2023-07-29").with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(startDayWith);

    }
}
