package Day80;

import static Day80.GreatestCommonDivisor.gcd;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println(lcm(4,6));
        System.out.println(zxgbs(4,6));
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int zxgbs(int a, int b) {
        int max = Math.max(a, b);
        for (int i = max;; i += max) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
    }
}
