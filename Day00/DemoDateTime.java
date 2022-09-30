package Day00;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DemoDateTime {
    public static void main(String[] args) {
        LocalDate myLocalDate = LocalDate.now();
        System.out.println(myLocalDate);

        LocalTime myLocalTime = LocalTime.now();
        System.out.println(myLocalTime);

        LocalDateTime myLocalDateTime = LocalDateTime.now();
        System.out.println(myLocalDateTime);

        DateTimeFormatter myFormatDT = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = myLocalDateTime.format(myFormatDT);
        System.out.println(formattedDate);
    }
}
