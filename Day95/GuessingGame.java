package Day95;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(101);
        int guess;
        boolean win = false;
        int tries = 0;
        System.out.println("猜数字游戏，范围是0到100");
        while (win == false) {
            Scanner sc = new Scanner(System.in);
            guess = sc.nextInt();
            if (guess == number) {
                win = true;
            } else if (guess < number) {
                System.out.println("太小了");
            } else {
                System.out.println("太大了");
            }
            tries ++;
        }
        System.out.println("恭喜你猜对了，答案是" + number);
        System.out.println("你一共试了" + tries + "次！");
    }
}
