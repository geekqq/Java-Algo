package Day286;

public class PalindromeInteger {

    public static boolean palindromeInt(int n) {
        boolean isNeg = n < 0;
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;
        int x = 0;
        while (n > x) {
            x = x * 10 + n % 10;
            n /= 10;
        }
        return n == x || n == x / 10;
    }

    public static void main(String[] args) {
        System.out.println(palindromeInt(1221));
        System.out.println(palindromeInt(1222));
        System.out.println(palindromeInt(-12));
        System.out.println(palindromeInt(0));
        System.out.println(palindromeInt(12321));
    }
}
