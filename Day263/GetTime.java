package Day263;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetTime {
    public static void main(String[] args) {
        System.out.println(Instant.now());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}
