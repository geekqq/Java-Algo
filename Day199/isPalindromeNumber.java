package Day199;

public class isPalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int n = 0;
        while (x > n) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return x == n || x == n / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome(1234));
        System.out.println(isPalindrome(12321));
    }
}
