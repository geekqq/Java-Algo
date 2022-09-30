package Day25;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input int a: ");
        int a = input.nextInt();
        System.out.println("input int b: ");
        int b = input.nextInt();
        System.out.println(gcd(a, b));
        System.out.println(zdgys(a, b));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static int zdgys(int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 0;
    }
}
