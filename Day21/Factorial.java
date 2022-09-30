package Day21;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(-1));
    }

    public static int factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}
