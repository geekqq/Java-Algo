package Day228;

import static Day173.ReverseString.swap;

public class ReverseWordsInString {

    public static String reverseWordsInString(String s) {
        if (s == null || s.length() == 0) return s;
        String reverseStr = reverseStr(s);
        String words = reverseEachWord(reverseStr);
        return clearSpaces(words.toCharArray());
    }

    private static String reverseStr(String s) {
        if (s == null || s.length() == 0) return null;
        char[] chars = s.toCharArray();
        int left =0;
        int right = chars.length - 1;
        while (left < right) {
            swap(chars, left++, right--);
        }
        return new String(chars);
    }

    private static String reverseEachWord(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            else {
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
        }
        return new String(chars);
    }
    private static String clearSpaces(char[] chars) {
        if (chars == null || chars.length == 0) return null;
        int i = 0;
        int j = 0;
        int n = chars.length;
        while (j < n) {
            while (j < n && chars[j] == ' ') j++;
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < n && chars[j] == ' ') j++;
            if (j < n) chars[i++] = ' ';
        }
        return new String(chars).substring(0, i);
    }

    public static void main(String[] args) {
        String s = "  hello world !  ";
        System.out.println(reverseWordsInString(s));
    }
}
