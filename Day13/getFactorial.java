package Day13;

public class getFactorial {
    public static void main(String[] args) {
        System.out.println(getFactorial(5));
    }

    public static int getFactorial(int n) {
        return n <= 1 ? 1 : n * getFactorial(n - 1);
    }
}
