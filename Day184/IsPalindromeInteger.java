package Day184;

public class IsPalindromeInteger {
    public static void main(String[] args) {
        System.out.println(isPalindromeInteger(100));
        System.out.println(isPalindromeInteger(101));
        System.out.println(isPalindromeInteger(10012));
    }

    public static boolean isPalindromeInteger(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int n = 0;
        while (x > n) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return x == n|| x == n / 10;
    }
}
