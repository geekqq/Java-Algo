package Day29;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int target = rand.nextInt(101);
        int guess;
        int numberOfTries = 0;
        boolean win = false;

        System.out.println("猜数字游戏，请在0-100猜一个数字：");
        while (win == false) {
            guess = new Scanner(System.in).nextInt();
            if (guess == target) {
                win = true;
          
            } else if (guess < target) {
                System.out.println("太小了：");
            } else {
                System.out.println("太大了：");
            }
            numberOfTries++;
        }
        System.out.println("猜对了。你一共猜了" + numberOfTries + "次。你好厉害哦！");
    }
}
