package Day275;

import java.time.Duration;
import java.time.Instant;

public class DynamicProgramming {

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int left = fib(n - 1);
        int right = fib(n - 2);
        return left + right;
    }

    public static int fibI(int n) {
        if (n < 2 && n >= 0) return n;
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static int fibII(int[] memo, int n) {
        if (memo[n] == 0) {
            if (n < 2) {
                memo[n] = n;
            } else {
                int left = fibII(memo, n - 1);
                int right = fibII(memo, n - 2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Instant startFib = Instant.now();
        System.out.println(fib(40));
        Instant endFib = Instant.now();
        System.out.println(Duration.between(startFib, endFib).getNano());

        Instant startFibI = Instant.now();
        System.out.println(fibI(40));
        Instant endFibI = Instant.now();
        System.out.println(Duration.between(startFibI, endFibI).getNano());

        Instant startFibII = Instant.now();
        System.out.println(fibII(new int[41], 40));
        Instant endFibII = Instant.now();
        System.out.println(Duration.between(startFibII, endFibII).getNano());

        for (int i = 0; i < 15; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < 15; i++) {
            System.out.print(fibI(i) + " ");
        }
        System.out.println();


    }
}
