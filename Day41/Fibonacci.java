package Day41;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.print(fibonacciTwo(i) + " ");
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) { //TODO: long
        if (n < 2) return n;
        int a = 0;
        int b = 0;
        int next = 1;

        for (int i = 2; i <= n; i++) {
            a = b;
            b = next;
            next = a + b;
        }
        return next;
    }

    public static int fibonacciTwo(int n) { //recursion
        if (n < 2) return n;
        return fibonacciTwo(n - 1) + fibonacciTwo(n - 2);
    }
}

