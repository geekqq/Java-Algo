package Day73;

import java.util.Random;
import java.util.Scanner;

public class GuessingNum {
    public static void main(String[] args) {
        int guess;
        Random rand = new Random();
        int number = rand.nextInt(101);
        int tries = 0;
        boolean win = false;
        System.out.println("Guess a number between 0 and 100");

        while (win == false) {
            Scanner sc = new Scanner(System.in);
            guess = sc.nextInt();

            if (guess == number) {
                win = true;
            } else if (guess > number) {
                System.out.println("too big");
            } else {
                System.out.println("too small");
            }
            tries++;
        }
        System.out.println("Great, you have won the game!");
        System.out.println("You have tried " + tries + " times");

    }
}
