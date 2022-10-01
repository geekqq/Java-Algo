package Day30;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int guessNumber = rand.nextInt(101);
        int guess;
        int numberOfTries = 0;
        boolean win = false;

        System.out.println("猜数字1-100，请输入你猜的数字，我告诉你大小：");
        while (win == false) {
            guess = new Scanner(System.in).nextInt();
            if (guess == guessNumber) {
                win = true;
            } else if (guess < guessNumber) {
                System.out.println("太小了：");
            } else {
                System.out.println("太大了：");
            }
            numberOfTries++;
        }
        System.out.println("猜对了，答案是" + guessNumber);
        System.out.println("您一共猜了" + numberOfTries + "次！");
    }
}
