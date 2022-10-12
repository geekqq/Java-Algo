package Day41;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGCD(3,6));
        System.out.println(zdgys(3,5));
    }

    public static int getGCD(int a, int b) {
        if (b == 0) return a;

        return a % b == 0 ? b : getGCD(b, a % b);
    }

    public static int zdgys(int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 0;
    }
}
