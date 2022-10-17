package Day46;

public class FibonacciNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < 15; i++) {
            System.out.print(getFibonacci(i) + " ");
        }
        System.out.println();
    }
    public static int fibonacci(int n) {
        if (n < 2) return n;

        int a = 0;
        int b = 0;
        int next = 1;
        for (int i = 2; i <= n ; i++) {
            a = b;
            b = next;
            next = a + b;
        }
        return next;
    }

    public static int getFibonacci(int n) {
        if (n < 2) return n;
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
