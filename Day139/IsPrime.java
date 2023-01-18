package Day139;

import java.util.Arrays;

public class IsPrime {
    private static boolean isPrime(int n) {
        if (n <= 3) return n > 1;
        if (n % 6 != 1 && n % 6 != 5) return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(10));
        long begin = System.currentTimeMillis();
        printPrimes(1000000);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (end - begin) + "milli seconds");
    }

    private static void printPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + ",");
            }
        }
        System.out.println();
    }
}
