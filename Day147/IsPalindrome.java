package Day147;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));

    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int n = 0;
        while (x > n) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return x == n || x == n / 10;
    }
}
