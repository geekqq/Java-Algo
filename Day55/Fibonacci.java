package Day55;

public class Fibonacci {
    public static void main(String[] args) {

    }

    public static int fibonacci(int n) {
        if (n < 3) return n;
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
