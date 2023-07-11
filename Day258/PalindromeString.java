package Day258;

public class PalindromeString {

    public static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("hello"));
        System.out.println(isPalindrome("that"));
        System.out.println(isPalindrome("thataht"));
        System.out.println(isPalindrome("KaaK"));
    }
}
