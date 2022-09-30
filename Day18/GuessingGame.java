package Day18;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int guessNumber = rand.nextInt(101);
        Scanner input = new Scanner(System.in);
        int numberOfTries = 0;
        boolean win = false;

        while (win == false) {
            System.out.println("请猜数字，范围是0 - 100：");
            int guess = input.nextInt();

            if (guess == guessNumber) {
                System.out.println("你真棒，猜中了!");
                win = true;
            } else if (guess > guessNumber) {
                System.out.println("太大了，再来一次吧：");
            } else {
                System.out.println("太小了，再来一次吧: ");
            }
            numberOfTries++;
        }
        System.out.println("你猜中的数字是：" + guessNumber + "。 你一共猜了" + numberOfTries + "次！");
    }
}
