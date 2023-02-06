package Day158;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2,4));
        System.out.println(myPow(2,-2));
    }

    private static double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n == 0) return 1;
        double half = myPow(x, n / 2);
        return (n & 1) == 0 ? half * half : half * half * x;
    }
}
