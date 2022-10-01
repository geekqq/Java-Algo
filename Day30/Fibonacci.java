package Day30;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(getFibonacci(i) + " ");
        }
    }

    public static int getFibonacci(int n) {
        if ( n < 2) return n;
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
