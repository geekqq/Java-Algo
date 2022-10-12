package Day40;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacciTwo(i) + " ");
        }
    }

    public static int fibonacci(int n) { //TODO: long
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci( n - 2);
    }
    
    public static int fibonacciTwo(int n) {
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
}
