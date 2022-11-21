package Day80;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(101);
        int guess;
        int tries = 0;
        boolean win = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("猜数字游戏，请输入一个0-100的数字：");
        while (win == false) {
            guess = sc.nextInt();
            if (guess == number) {
                win = true;
            } else if (guess > number) {
                System.out.println("太大了");
            } else {
                System.out.println("太小了");
            }
            tries++;
        }
        System.out.println("恭喜你答对了，答案是" + number);
        System.out.println("您一共试了" + tries + "次！");
    }
}
