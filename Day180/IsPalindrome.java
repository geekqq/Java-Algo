package Day180;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(13));
        System.out.println(isPalindrome(2));
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome(12321));
    }

    private static Boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int n = 0;
        while (x > n) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return x == n || x == n / 10;
    }
}
