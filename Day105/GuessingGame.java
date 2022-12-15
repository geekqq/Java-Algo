package Day105;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(101);
        int guess;
        int tries = 0;
        boolean win = false;
        System.out.println("猜数字游戏开始啦：范围0-100：");
        while (win == false) {
            Scanner sc = new Scanner(System.in);
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
        System.out.println("恭喜你，猜中了。");
        System.out.println("您一共猜了" + tries + "次！");
    }
}
