package Day44;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        for (int i = 0; i < 20; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        System.out.println(fibonacci2(4));
    }

    public static int fibonacci(int n) {
        //print the nth fibonacci number
        if (n < 2) {
            return n;
        }
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

    public static int fibonacci2(int n) {
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
