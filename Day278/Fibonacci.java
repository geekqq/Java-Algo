package Day278;

import java.time.Duration;
import java.time.Instant;

public class Fibonacci {

    public static int fib(int n) {
        if (n < 2 && n >= 0) return n;
        int left = fib(n - 1);
        int right = fib(n - 2);
        return left + right;
    }

    public static int fibI(int n) {
        if (n == 0 || n == 1) return n;
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static int fibII(int n) {
        int[] memo = new int[n + 1];

        if (memo[n] == 0) {
            if (n < 2) {
                memo[n] = n;
            } else {
                int left = fibII(n - 1);
                int right = fibII(n - 2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Instant startFib = Instant.now();
        for (int i = 0; i < 32; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
        Instant endFib = Instant.now();
        System.out.println(Duration.between(startFib, endFib).getNano());
        System.out.println();

        Instant startFibI = Instant.now();
        for (int i = 0; i < 32; i++) {
            System.out.print(fibII(i) + " ");
        }
        System.out.println();
        Instant endFibI = Instant.now();
        System.out.println(Duration.between(startFibI, endFibI).getNano());
        System.out.println();

        Instant startFibII = Instant.now();
        for (int i = 0; i < 32; i++) {
            System.out.print(fibI(i) + " ");
        }
        System.out.println();
        Instant endFibII = Instant.now();
        System.out.println(Duration.between(startFibII, endFibII).getNano());
    }
}
