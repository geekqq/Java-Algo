package Day51;

public class GreatCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(8,12));
        System.out.println(zdgys(8,12));
    }

    public static int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }
        return n % m == 0 ? m : gcd(m, n % m);
    }

    public static int zdgys(int n, int m) {
        int min = Math.min(n, m);
        for (int i = min; i > 0 ; i--) {
            if (n % i == 0 && m % i == 0) {
                return i;
            }
        }
        return 0;
    }
}
