package Day206;

public class PalindromeNumber {

    public static boolean isPalindromeNumber(int x) {
        if (x < 0 || (x %10 == 0 && x != 0)) return false;
        int n = 0;
        while (x > n) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return x == n || x == n / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(0));
        System.out.println(isPalindromeNumber(100));
        System.out.println(isPalindromeNumber(1));
        System.out.println(isPalindromeNumber(1234));
        System.out.println(isPalindromeNumber(12321));
    }
}
