package Day242;

import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {
        String ip = "192.168.1.123";
        String ip2 = "10.0.0.256";
        System.out.println(isValidIPAddress(ip));
        System.out.println(isValidIPAddress(ip2));
    }

    public static boolean isValidIPAddress(String ipAddress) {
        if (ipAddress == null || ipAddress.length() == 0) return false;
        String num = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
        String regex = num + "." + num + "." + num + "." + num;

        Pattern p = Pattern.compile(regex);
        return p.matcher(ipAddress).matches();
    }
}
