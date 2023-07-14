package Day259;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface //can only have one abstract method
public interface UPIPayment {

    String doPayment(String source, String dest);
    //void test()
    default double getScratchCard() {
        return new Random().nextDouble();
    }
    static String datePatterns(String patterns) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(patterns);
        return dateFormat.format(new Date());
    }
}
