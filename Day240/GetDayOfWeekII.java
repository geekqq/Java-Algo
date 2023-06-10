package Day240;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class GetDayOfWeekII {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int month = sc.nextInt();
            int day = sc.nextInt();
            int year = sc.nextInt();

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DATE, day);
            cal.set(Calendar.MONTH, month - 1);
            cal.set(Calendar.YEAR, year);
            System.out.println(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("en", "US")).toUpperCase());
        }
    }
}
