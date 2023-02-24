package Day174;

import static Day173.ReverseString.swap;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("jinwei"));
    }

    private static String reverseString(String s) {
        if (s == null || s.length() == 0) return null;
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            swap(chars, left++, right--);
        }
        return String.valueOf(chars);
    }
}
