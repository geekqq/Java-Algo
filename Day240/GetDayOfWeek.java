package Day240;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class GetDayOfWeek {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String dateString = sc.nextLine();
        DateFormat df = new SimpleDateFormat("MM DD YYYY");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        int day = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
        switch (day) {
            case 1 :
                System.out.println("SUNDAY");
                break;
            case 2 :
                System.out.println("MONDAY");
                break;
            case 3 :
                System.out.println("TUESDAY");
                break;
            case 4 :
                System.out.println("WEDNESDAY");
                break;
            case 5 :
                System.out.println("THURSDAY");
                break;
            case 6 :
                System.out.println("FRIDAY");
                break;
            case 7 :
                System.out.println("SATURDAY");
                break;
        }
    }
}
