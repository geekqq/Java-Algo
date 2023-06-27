package Day252;

public class TimeConversion {

    public static String timeConversion(String s) {
        String hour = s.substring(0, 2);
        String amPm = s.substring(s.length() - 2);
        if (hour.equals("12") && amPm.equals("AM")) {
            s = s.replaceFirst("12", "00");
            return s.substring(0, s.length() - 2);
        } else if (!hour.equals("12") && amPm.equals("PM")) {
            return s.replaceFirst(hour, Integer.parseInt(hour) + 12 + "").substring(0, s.length() - 2);
        } else {
            return s.substring(0, s.length() - 2);
        }
    }
    public static void main(String[] args) {
        System.out.println(timeConversion("12:01:00AM"));
        System.out.println(timeConversion("12:01:00PM"));
        System.out.println(timeConversion("01:01:00AM"));
        System.out.println(timeConversion("02:01:00PM"));
        System.out.println("+++++++++++++");
        System.out.println(timeConversionII("12:01:00AM"));
        System.out.println(timeConversionII("12:01:00PM"));
        System.out.println(timeConversionII("01:01:00AM"));
        System.out.println(timeConversionII("02:01:00PM"));
    }

    public static String timeConversionII(String s) {
        String hour = s.substring(0, 2);
        String a = hour;
        if (s.charAt(8) == 'A' && hour.equals("12")) {
            a = "00";
        } else if (s.charAt(8) == 'P' && !hour.equals("12")) {
            a = String.valueOf(Integer.parseInt(hour) + 12);
        }
        return a + s.substring(2, 8);
    }
}
