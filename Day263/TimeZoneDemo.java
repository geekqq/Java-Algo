package Day263;

import java.time.*;
import java.util.Set;

public class TimeZoneDemo {
    public static void main(String[] args) {


        Instant start = Instant.now();
        System.out.println(start);
        ZoneId zoneId = ZoneId.of("Asia/Tokyo");

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);


        System.out.println("=================");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        System.out.println(zonedDateTime);
        LocalDateTime localDateTime = LocalDateTime.of(2023, Month.JULY, 29, 6, 55);
        System.out.println(localDateTime);
        ZoneOffset offset = ZoneOffset.of("+15:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, offset);
        System.out.println(offsetDateTime);
        Instant end = Instant.now();
        System.out.println("=================");
        System.out.println(end);
        long duration = Duration.between(start, end).getNano();
        System.out.println(duration);

    }
}
