package Day12;

public class DemoFactorial {
    public static void main(String[] args) {
        System.out.println(factorial(18));
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }
}
