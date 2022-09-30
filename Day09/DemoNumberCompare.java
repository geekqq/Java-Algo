package Day09;

import java.util.Scanner;

public class DemoNumberCompare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pls input the first number: ");
        int num1 = input.nextInt();
        System.out.println("pls input the second number: ");
        int num2 = input.nextInt();
        if (num2 == num1) {
            System.out.printf("%d equals to %d", num1, num2);
        } else if (num2 > num1) {
            System.out.printf("%d is greater than %d", num2, num1);
        } else {
            System.out.printf("%d is smaller than %d", num2, num1);
        }
    }
}

