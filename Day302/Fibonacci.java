package Day302;

public class Fibonacci {

    public static int fib(int n) {
        if (n >= 0 && n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibI(int n) {
        if (n >= 0 && n < 2) return n;
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static int fibII(int n) {
        int[] memo = new int[n + 1];
        if (memo[n] == 0) {
            if (n < 2 && n >= 0) memo[n] = n;
            else {
                memo[n] = fibII(n - 1) + fibII(n - 2);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < 15; i++) {
            System.out.print(fibI(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < 15; i++) {
            System.out.print(fibII(i) + " ");
        }
        System.out.println();
    }
}