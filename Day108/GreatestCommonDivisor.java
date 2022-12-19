package Day108;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(8,6));
        System.out.println(zdgys(8,6));
    }
    public static int zdgys(int a, int b) {
        if (b == 0) return a;
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 0;
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
