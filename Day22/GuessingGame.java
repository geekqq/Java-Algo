package Day22;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int guessNumber = rand.nextInt(101);
        int guess;
        int numberOfTries = 0;
        boolean win = false;

        while (win == false) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please guess a number from 0 to 100");
            guess = input.nextInt();
            if (guess == guessNumber) win = true;
            else if (guess > guessNumber) System.out.println("It's too high, try again.");
            else System.out.println("It's too low, try again.");
            numberOfTries++;
        }
        System.out.println("You won!");
        System.out.println("The guess number is: " + guessNumber);
        System.out.println("You have tried " + numberOfTries + " times!");
    }
}
