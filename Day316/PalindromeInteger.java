package Day316;

public class PalindromeInteger {
    public static boolean palindromeNumber(int n) {
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;
        int x = 0;
        while (n > x) {
            x = x * 10 + n % 10;
            n /= 10;
        }
        return n == x || n == x / 10;
    }

    public static void main(String[] args) {
        System.out.println(palindromeNumber(12321));
        System.out.println(palindromeNumber(100));
        System.out.println(palindromeNumber(0));
        System.out.println(palindromeNumber(-12));
    }
}
