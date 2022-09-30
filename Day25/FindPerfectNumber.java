package Day25;

public class FindPerfectNumber {
    public static void main(String[] args) {
        System.out.println(ifPerfect(6));
        for (int i = 0; i < 10001; i++) {
            if (ifPerfect(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean ifPerfect(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2 ; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
}
