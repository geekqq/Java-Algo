package Day131;

public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2, 3));
    }
    public static double myPow(double x, int n) {
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
}
