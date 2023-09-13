package Day294;

public class PalindromeNumber {

    public static boolean isPalindromeNum(int n) {
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;
        int x = 0;
        while (n > x) {
            int lastDigit = n % 10;
            x = x * 10 + lastDigit;
            n /= 10;
        }
        return x == n || x / 10 == n;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNum(1221));
        System.out.println(isPalindromeNum(12421));
        System.out.println(isPalindromeNum(1220));
    }
}
