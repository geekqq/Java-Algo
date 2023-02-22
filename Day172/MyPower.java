package Day172;

public class MyPower {
    public static void main(String[] args) {
        System.out.println(myPower(2, -3));
    }

    private static double myPower(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n == 0) return 1;
        double res = 1;
        double half = myPower(x, n / 2);
        return (n & 1) == 0 ? half * half : half * half * x;
    }
}
