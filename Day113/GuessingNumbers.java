package Day113;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumbers {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(101);
        int tries = 0;
        int guess;
        boolean win = false;
        System.out.println("猜数字游戏开始啦：");
        while (win == false) {
            Scanner sc = new Scanner(System.in);
            guess = sc.nextInt();
            if (number == guess) {
                win = true;
            } else if (guess > number) {
                System.out.println("太大了！");
            } else {
                System.out.println("太小了");
            }
            tries ++;
        }
        System.out.println("恭喜你，猜对了！");
        System.out.println("一共试了" + tries + "次！");
    }
}
