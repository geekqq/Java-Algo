package TechbowAlgoPractice;

public class MyPower {

    public static double myPower(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }

    public static double myPowerI(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n == 0) return 1;
        //if (n == 1) return x;
        double half = myPowerI(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    public static void main(String[] args) {
        System.out.println(myPower(2,-3));
        System.out.println(myPowerI(2,-3));
    }
}
