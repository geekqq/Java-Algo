package Day17;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(101);
        Scanner input = new Scanner(System.in);
        int numberOfTries = 0;
        int guess;
        boolean win = false;

        while (win == false) {
            System.out.println("Input your guess from 1 - 100: ");
            guess = input.nextInt();
            numberOfTries++;

            if (guess == numberToGuess ) {
                System.out.println("You won!");
                win = true;
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high, try again.");
            } else {
                System.out.println("Youg guess is too low, try again");
            }
        }
        System.out.println("the guess number was: " + numberToGuess);
        System.out.println("It took you " + numberOfTries + " tries.");
    }
}
