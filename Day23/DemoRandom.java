package Day23;

import java.util.Random;

public class DemoRandom {
    public static void main(String[] args) {
        for (int i = 1; ; i++) {
            double n = Math.random();
            if (n > 0.999) {
                System.out.println("在第" + i + "次出现了大于0.999的数字，这个数字是" + n);
                break;
            }
        }
    }
}
