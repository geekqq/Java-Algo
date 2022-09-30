package Day24;

public class PerfectNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 10001; i++) {
            if (isPerfectNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
}
