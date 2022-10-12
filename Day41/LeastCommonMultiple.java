package Day41;

import static Day41.GreatestCommonDivisor.getGCD;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println(getLCM(6,10));
        System.out.println(zxgbs(6, 10));
    }

    public static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
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
