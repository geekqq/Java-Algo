package Day262;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandleDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Enter a whole number to divide: ");
            int x = scanner.nextInt();

            System.out.println("Enter a whole number to divide by:");
            int y = scanner.nextInt();

            int z = x / y;
            System.out.println("result: " + z);
        } catch (ArithmeticException e) {
            System.out.println("You can not divide by zero, IDIOT!");
        } catch (InputMismatchException e) {
            System.out.println("please enter a number OMFG!");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        finally {
            System.out.println("This will always print!");
            scanner.close();
        }
    }
}
