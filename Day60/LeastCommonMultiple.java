package Day60;

import static Day60.GreatestCommonDivisor.gcd;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println(lcm(6,9));
        System.out.println(zxgbs(6,18));
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int zxgbs(int a, int b) {
        int max = Math.max(a, b);
        for (int i = max; ; i += max) {
            if (max % a == 0 && max % b == 0) {
                return max;
            }
        }
    }
}
