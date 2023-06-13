package Day242;

import java.util.List;
import java.util.regex.Pattern;

public class ValidIpAddress {

    private static final String IP_ADDRESS_REGEX =
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";


    public static boolean isValidIpAddress(String ipAddress) {
        Pattern pattern = Pattern.compile(IP_ADDRESS_REGEX);
        return pattern.matcher(ipAddress).matches();
    }

    public static void main(String[] args) {
        String[] ips = {
                "000.12.12.034",
                "121.234.12.12",
                "23.45.12.56",
                "000.12.234.23.23",
                "666.666.23.23",
                ".213.123.23.32",
                "23.45.22.32.",
                "I.Am.not.an.ip"
        };
        for (String ip : ips) {
            if (isValidIpAddress(ip)) {
                System.out.println(ip + " is valid ip address" );
            } else {
                System.out.println(ip + " is not valid ip address");
            }
        }
    }
}
