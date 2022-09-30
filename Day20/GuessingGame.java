package Day20;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand= new Random();
        int target = rand.nextInt(101);
        int numberOfTries = 0;
        int guess;
        boolean win = false;

        while (win == false) {
            System.out.println("Guess a number from 0 - 100: ");
            Scanner input = new Scanner(System.in);
            guess = input.nextInt();

            if (guess == target) win = true;
            else if (guess > target) System.out.println("You are too high, please try again: ");
            else System.out.println("You are too low, please try again: ");
            numberOfTries++;
        }
        System.out.println("You won! You tried " + numberOfTries + " times!");
    }
}
