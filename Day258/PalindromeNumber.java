package Day258;

public class PalindromeNumber {

    public static boolean isPalindromeNum(int n) {
        if (n < 0) return false;
        if (n % 10 == 0 && n != 0) return false;
        int x = 0;
        while (x < n) {
            x = x * 10 + n % 10;
            n /= 10;
        }
        return n == x || n == x / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNum(0));
        System.out.println(isPalindromeNum(100));
        System.out.println(isPalindromeNum(1221));
        System.out.println(isPalindromeNum(123));
    }
}
