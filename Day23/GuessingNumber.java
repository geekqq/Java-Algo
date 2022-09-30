package Day23;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int guessNum = rand.nextInt(101);
        int guess;
        int numberOfTries = 0;
        boolean win = false;

        while (win == false) {
            System.out.println("请输入您猜的数字，范围是0-100：");
            Scanner input = new Scanner(System.in);
            guess = input.nextInt();

            if (guess == guessNum) {
                win = true;
            } else if (guess > guessNum) {
                System.out.println("太大了，请再试一次：");
            } else {
                System.out.println("太小了，请再试一次：");
            }
            numberOfTries++;
        }
        System.out.println("您猜中了！");
        System.out.println("一共猜了" + numberOfTries + "次！");
    }
}
