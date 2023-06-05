package Day237;

import static Day173.ReverseString.swap;

public class ReverseEachWord {
    public static String reverseEachWord(String s) {
        if (s == null || s.length() == 0) return s;
        String reversedStr = reverseString(s);
        char[] chars = reversedStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }
            int j = i + 1;
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            int start = i;
            int end = j - 1;
            while (start < end) {
                swap(chars, start++, end--);
            }
            i = j;
        }
        return new String(chars);
    }
    private static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            swap(chars, left++, right--);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = " hello world!";
        System.out.println(reverseEachWord(s));
    }
}
