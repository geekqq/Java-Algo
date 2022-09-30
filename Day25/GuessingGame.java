package Day25;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int target = rand.nextInt(101);
        int times = 0;
        boolean win = false;

        while (win == false) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入1-100之间的数字：");
            int guess = input.nextInt();
            if (guess == target) {
                win = true;
            } else if (guess > target) {
                System.out.println("太大了");
            } else {
                System.out.println("太小了");
            }
            times++;
        }

        System.out.println("恭喜你猜中了！");
        System.out.println("一共试了" + times + "次！");
    }
}
