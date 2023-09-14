package Day295;

public class PalindromeNumber {

    public static boolean isPalindromeNumber(int n) {
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;
        int x = 0;
        while (n > x) {
            x = n % 10 + x * 10;
            n /= 10;
        }
        return x == n || x / 10 == n;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(-1234));
        System.out.println(isPalindromeNumber(0));
        System.out.println(isPalindromeNumber(1221));
        System.out.println(isPalindromeNumber(10));
        System.out.println(isPalindromeNumber(100));
        System.out.println(isPalindromeNumber(101));
    }
}
