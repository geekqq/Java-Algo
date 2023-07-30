package Day263;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OldToNewDateConversion {

    public static void main(String[] args) {
        Date date = new Date();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println(date);
        System.out.println(localDateTime);

        System.out.println("===============");
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localDate);
        System.out.println(localTime);

        System.out.println("===============");
        Calendar calendar = Calendar.getInstance();
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime1);

        System.out.println("===============");
        LocalDateTime localDateTime2 = LocalDateTime.of(2023, Month.JULY, 29, 8, 27);
        System.out.println(localDateTime2);
        String format = localDateTime2.format(DateTimeFormatter.ISO_DATE);
        System.out.println(format);

        String format1 = localDateTime2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(format1);

        String format2 = localDateTime2.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.UK));
        String format3 = localDateTime2.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.CANADA));
        String format4 = localDateTime2.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US));
        String format5 = localDateTime2.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.CHINA));
        System.out.println("UK " + format2);
        System.out.println("CANADA " + format3);
        System.out.println("US " + format4);
        System.out.println("CHINA " + format5);

    }
}
