package Day231;

import static Day173.ReverseString.swap;

public class ReverseByEachWord {

    public static String reverseByWord(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            int j = i + 1;
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            int left = i;
            int right = j - 1;
            while (left < right) {
                swap(chars, left++, right--);
            }
            i = j;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "hello world";
        System.out.println(reverseByWord(s));
    }
}
