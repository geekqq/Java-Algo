package Day248;

public class IsPalindromeNumber {
    public static boolean isPalindromeNumber(int n) {
        if (n < 0 || n % 10 == 0 && n != 0) return false;
        int m = 0;
        while (n > m) {
            m = m * 10 + n % 10;
            n /= 10;
        }
        return n == m || n == m / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(10));
        System.out.println(isPalindromeNumber(101));
        System.out.println(isPalindromeNumber(1012));
        System.out.println(isPalindromeNumber(1212));
        System.out.println(isPalindromeNumber(1221));
    }
}
