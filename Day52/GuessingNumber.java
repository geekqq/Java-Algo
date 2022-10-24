package Day52;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("猜数字游戏，范围是0 - 100");
        int number = rand.nextInt(101);
        System.out.println("请输入你猜测的数字：");
        int tries = 0;
        boolean win = false;

        while (win == false) {
            Scanner sc = new Scanner(System.in);
            int guess = sc.nextInt();
            if (guess == number) {
                win = true;
            } else if (guess < number) {
                System.out.println("太小了");
            } else {
                System.out.println("太大了");
            }
            tries++;
        }
        System.out.println("恭喜你答对了，答案就是" + number);
        System.out.println("您一共试了" + tries + "次！");
    }
}
