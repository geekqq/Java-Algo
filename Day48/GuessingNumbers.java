package Day48;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumbers {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(101);
        System.out.println("猜数字游戏：范围是0-100");
        System.out.println("请输入你猜测的数字，我告诉你大了或者小了：");
        int tries = 0;
        boolean win = false;

        while (win == false) {
            Scanner sc = new Scanner(System.in);
            int guess = sc.nextInt();

            if (guess == number) {
                win = true;
            } else if (guess < number) {
                System.out.println("太小了！");
            } else {
                System.out.println("太大了！");
            }
            tries++;
        }
        System.out.println("太棒了，你猜对了！");
        System.out.println("您一共试了" + tries + "次！");
    }
}
