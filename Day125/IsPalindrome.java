package Day125;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(45554));
        System.out.println(isPalindrome2(-45554));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i < j; i++,j--) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int n = 0;
        while (x > n) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return x == n || x == n / 10;
    }
}
