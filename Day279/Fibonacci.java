package Day279;

public class Fibonacci {

    public static int fib(int n) {
        if (n < 2 && n >= 0) return n;
        return fib(n - 1) + fib(n - 2);
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

    public static int fibII(int n) {
        int[] memo = new int[n + 1];
        if (memo[n] == 0) {
            if (n < 2) {
                memo[n] = n;
            }  else {
                memo[n] = fibII(n - 1) + fibII(n - 2);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.println(fibII(i) + " ");
        }
    }
}
