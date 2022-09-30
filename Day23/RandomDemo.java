package Day23;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(new Random().nextInt(5));
        }
    }
}
