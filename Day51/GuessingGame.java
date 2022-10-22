package Day51;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        System.out.println("猜数字游戏，范围是0到1000");
        Random rand = new Random();
        int number = rand.nextInt(1001);
        int tries = 0;
        int guess;
        boolean win = false;
        System.out.println("请输入你猜测的数字：");


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
            tries++;
        }
        System.out.println("猜对了，恭喜你，答案是" + number);
        System.out.println("您一共猜了" + tries + "次！");
    }
}
