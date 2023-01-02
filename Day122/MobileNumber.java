package Day122;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumber {
    public static boolean isValidMobileNumber(String s) {
        return s.matches("\\d{10}");
    }

    public static void main(String[] args) {
        String regex = "\\d{3,4}-\\d{7,8}";
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(regex)) {
                System.out.println("测试失败" + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.213")) {
            if (s.matches(regex)) {
                System.out.println("测试失败" + s);
                return;
            }
        }
        System.out.println("测试成功！");
        Pattern pattern = Pattern.compile("([00-23]\\d):([00-59]\\d):([00-59]\\d)");
        Matcher matcher = pattern.matcher("05:34:02");
        if (matcher.matches()) {
            String whole = matcher.group(0);
            String hour = matcher.group(1);
            String min = matcher.group(2);
            String sec = matcher.group(3);
            System.out.println(whole);
            System.out.println(hour);
            System.out.println(min);
            System.out.println(sec);
        }
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
    }
}
