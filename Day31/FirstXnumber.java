package Day31;

import java.util.Random;

public class FirstXnumber {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; ; i++) {
            double number = rand.nextDouble();
            if (number > 0.999) {
                System.out.println("第" + i + "次出现大于0.999的数字是: " + number);
                break;
            }
        }
    }
}
