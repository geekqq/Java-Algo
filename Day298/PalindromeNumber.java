package Day298;

public class PalindromeNumber {

    public static boolean palindromeNumber(int n) {
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;
        int x = 0;
        while (n > x) {
            x = x * 10 + n % 10;
            n /= 10;
        }

        return x == n || x / 10 == n;
    }

    public static void main(String[] args) {
        System.out.println(palindromeNumber(10));
        System.out.println(palindromeNumber(0));
        System.out.println(palindromeNumber(101));
        System.out.println(palindromeNumber(1231));
        System.out.println(palindromeNumber(12321));
    }
}
