package Day29;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacciOne(5));
    }

    public static int fibonacci(int n) {
        int f0 = 0;
        int f1 = 1;
        int next = 0;

        for (int i = 3; i <= n ; i++) {
            next = f0 + f1;
            f0 = f1;
            f1 = next;
        }
        return next;
    }

    public static int fibonacciOne(int n) {
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacciOne(n - 2);
    }
}
