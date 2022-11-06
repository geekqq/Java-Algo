package Day65;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumbers {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(101);
        System.out.println("猜数字游戏，请输入一个数字，大小在0到100之间：");
        boolean win = false;
        int tries = 0;

        while(win == false) {
            Scanner sc = new Scanner(System.in);
            int guess = sc.nextInt();
            if (guess == number) {
                win = true;
            } else if (guess > number) {
                System.out.println("太大了：");
            } else {
                System.out.println("太小了：");
            }
            tries++;
        }
        System.out.println("恭喜你答对了！");
        System.out.println("你一共试了" + tries + "次！");
    }
}
