package Day25;

import java.util.Scanner;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println("input a: ");
        int a = new Scanner(System.in).nextInt();
        System.out.println("input b: ");
        int b = new Scanner(System.in).nextInt();
        System.out.println(lcm(a, b));
        System.out.println(zxgbs(a, b));
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static int zxgbs(int a, int b) {
        int max = Math.max(a, b);
        for (int i = max; ; i += max) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
    }


}
