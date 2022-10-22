package Day51;

import static Day51.GreatCommonDivisor.gcd;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println(lcm(8,12));
        System.out.println(zxgbs(8,12));
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int zxgbs(int n, int m) {
        int max = Math.max(n, m);
        for (int i = max; ; i += max) {
            if (i % n == 0 && i % m == 0) {
                return i;
            }
        }
    }
}
