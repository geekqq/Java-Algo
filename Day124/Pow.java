package Day124;

public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(5,-2));
    }
    public static double myPow(double x, int n) {
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double res = 1;
        for (int i = 0; i < N; i++) {
            res *= x;
        }
        return res;
    }
}
