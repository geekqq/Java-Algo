package Day239;

import static Day173.ReverseString.swap;
import static Day239.ClearSpaces.clearSpaces;

public class ReverseEachWord {

    public static String reverseEachWord(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            swap(chars, left++, right--);
        }
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
        return clearSpaces(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("   hello  world   "));
    }
}
