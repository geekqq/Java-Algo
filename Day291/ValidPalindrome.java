package Day291;

public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        String s1 = s.toLowerCase();
        if (s == null) return false;
        if (s.length() == 0) return true;
        int i = 0;
        int j = s.length() -  1;
        while (i < j) {
            if (s1.charAt(i++) != s1.charAt(j--)) return false;
        }
        return true;
    }


    public static boolean validPalindromeI(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else if (s.toLowerCase().charAt(i++) != s.toLowerCase().charAt(j--)) return false;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome(" "));
        System.out.println(validPalindrome("stone"));
        System.out.println(validPalindrome("12321"));
        System.out.println("=====");
        System.out.println(validPalindromeI(" "));
        System.out.println(validPalindromeI("hi"));
        System.out.println(validPalindromeI("12321"));
    }
}
