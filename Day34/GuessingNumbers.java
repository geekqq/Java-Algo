package Day34;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumbers {
    public static void main(String[] args) {

        int target = new Random().nextInt(101);
        int guess;
        boolean win = false;
        int numberOfGuess = 0;


        System.out.println("猜数字游戏，请输入你猜的数字，范围为到100：");
        while (win == false) {
            guess = new Scanner(System.in).nextInt();
            if (guess == target) {
                win = true;
            } else if (guess > target) {
                System.out.println("太大了：");
            } else {
                System.out.println("太小了：");
            }
            numberOfGuess++;
        }
        System.out.println("猜对了。");
        System.out.println("你真厉害，一共猜了" + numberOfGuess + "次！");

    }


}
