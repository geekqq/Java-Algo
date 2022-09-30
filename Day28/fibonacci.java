package Day28;

public class fibonacci {
    public static void main(String[] args) {
        int n = 5;
        fibonacci(n);
        System.out.println();
        System.out.println(fibonacciOne(n));
    }

    public static void fibonacci(int n) {
        int a = 1, b = 1, c = 0;
        System.out.print(a + "\t" + b + "\t");
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + "\t");
        }
    }

    public static int fibonacciOne(int n) {
        if (n < 2) return n;
        else return fibonacciOne(n - 1) + fibonacciOne(n - 2);
    }
}
