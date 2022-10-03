package Day31;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println("--------------");

        for (int i = 0; i <= 10; i++) {
            System.out.println(factorial(i));
        }

    }

    public static long factorial(int n) {
        return n < 2 ? 1 : factorial(n - 1) * n;
    }
}
