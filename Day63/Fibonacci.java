package Day63;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) { //TODO: long
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
}
