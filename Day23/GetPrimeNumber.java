package Day23;

import java.util.Scanner;

public class GetPrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入任意数字");
        int number = input.nextInt();
        System.out.println(isPrimer(number));
    }

    public static Boolean isPrimer(int number) {
        if (number < 2) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
