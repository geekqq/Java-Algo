package Day158;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.print(fib(i) + ",");
        }
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.print(fibII(i) + ",");
        }
    }

    private static int fib(int x) {
        if (x < 2) return x;
        return fib(x - 2) + fib(x - 1);
    }

    private static int fibII(int x) {
        if (x < 2) return x;
        int a = 0;
        int b = 0;
        int next = 1;
        for (int i = 2; i <= x; i++) {
            a = b;
            b = next;
            next = a + b;
        }
        return next;
    }
}
