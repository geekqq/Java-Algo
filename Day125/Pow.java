package Day125;

public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2,0));
        System.out.println(myPow2(2,-3));
    }
    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        double res = 1d;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }

    public static double myPow2(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        if (n == 0) {
            return 1;
        }
        double half = myPow2(x, n/2);
        return (1 & n) == 0 ? half * half : half * half * x;
    }
}
