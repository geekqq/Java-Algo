package Day129;

public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2,-4));
        System.out.println(myPow2(2, -4));
    }

    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double res = 1d;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }

    public static double myPow2(double x, int n) {
        if (x == 0) return 0;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n == 0) return 1;
        double half = myPow2(x, n / 2);
        return (n & 1) == 0 ? half * half : half * half * x;
    }
}
