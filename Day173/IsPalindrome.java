package Day173;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(1221));
    }

    private static boolean isPalindrome(int n) {
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;
        int x = 0;
        while (n > x) {
            x = x * 10 + n % 10;
            n /= 10;
        }
        return n == x || n == x / 10;
    }
}
