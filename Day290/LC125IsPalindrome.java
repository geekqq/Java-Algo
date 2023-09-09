package Day290;

public class LC125IsPalindrome {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        String s1 = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s1.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }
        String newString = sb.toString();
        System.out.println(newString);
        return isValidPalindrome(newString);
    }

    private static boolean isValidPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(s1));
        System.out.println(isValidPalindrome("amanaplanacanalpanama"));
    }
}
