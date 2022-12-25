package Day114;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 25; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 25; i++) {
            System.out.print(fibonacci2(i) + " ");
        }
    }
    public static int fibonacci(int n) {
        if (n <= 1) return n;
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
        if (n <= 1) return n;
        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }
}
