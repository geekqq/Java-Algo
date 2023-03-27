package Day202;

public class MyPower {

    public static double myPower(double n, int x) {
        if (x < 0) {
            x = -x;
            n = 1 / n;
        }
        if (x == 0) return 1;
        double half = myPower(n, x / 2);
        return x % 2 == 0 ? half * half : half * half * n;
    }

    public static void main(String[] args) {
        System.out.println(myPower(4,-2));
    }
}
