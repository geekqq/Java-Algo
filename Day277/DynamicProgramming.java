package Day277;

public class DynamicProgramming {

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int left = fib(n - 1);
        int right = fib(n - 2);
        return left + right;
    }

    public static int fibI(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static int fibII(int n) {
        int[] memo = new int[n + 1];
        if (memo[n] == 0) {
            if (n < 2) {
                memo[n] = n;
            } else {
                int left = fibII(n - 1);
                int right = fibII(n - 2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(40));
        System.out.println(fibI(40));
        System.out.println(fibII(40));
    }
}
