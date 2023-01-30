package Day150;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(101);
        System.out.println("guess a number from 0 to 100");
        int tries = 0;
        boolean win = false;
        while (win == false) {
            Scanner sc = new Scanner(System.in);
            int guess = sc.nextInt();
            if (guess == number) {
                win = true;
            } else if (guess < number) {
                System.out.println("too small");
            } else {
                System.out.println("too big");
            }
            tries++;
        }
        System.out.println("Your guess is correct, congrats!!");
        System.out.println("You have tried " + tries + " times!");
    }
}
