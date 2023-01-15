package Day135;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 23; i++) {
            System.out.print(fibonacci2(i)+ " ");
        }
    }

    private static int fibonacci(int x) {
        if (x < 2) {
            return x;
        }
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

    private static int fibonacci2(int x) {
        if (x < 2 ) return x;
        return fibonacci2(x- 1) + fibonacci2(x - 2);
    }
}

