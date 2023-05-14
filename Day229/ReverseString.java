package Day229;

import static Day173.ReverseString.swap;

public class ReverseString {

    public static String reverseString(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            swap(chars, left++, right--);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello!"));
    }
}
