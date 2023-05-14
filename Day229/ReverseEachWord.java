package Day229;

import static Day173.ReverseString.swap;

public class ReverseEachWord {
    public static String reverseEachWord(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && chars[i] == ' ') {
                i++;
            }
            int j = i + 1;
            while (j < s.length() && chars[j] != ' ') {
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
        System.out.println(reverseEachWord(" hello world!  "));
    }
}
