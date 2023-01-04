package Day124;

public class Pow2 {
    public static void main(String[] args) {
        System.out.println(Pow2(2, -3));
    }
    public static double Pow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1.0;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }
}
