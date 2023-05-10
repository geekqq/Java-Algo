package Day226;

import static Day173.ReverseString.swap;

public class ReverseWordInString {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return null;
        String str = cleanExtraSpace(s);
        String reversedStr = reverse(str);
        String words = reverseEachWord(reversedStr);

        return cleanSpace(words.toCharArray());
    }

    // remove the extra spaces at both ends
    private static String cleanExtraSpace(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() && s.charAt(left) == ' ') left++;
        while (right >= 0 && s.charAt(right) == ' ') right--;
        if (left > right) return "";
        return s.substring(left, right + 1);
    }

    private static String reverse(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            swap(chars, left++, right--);
        }
        return new String(chars);
    }

    private static String reverseEachWord(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            else if (chars[i] != ' ') {
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

    private static String cleanSpace(char[] chars) {
        int i = 0;
        int j = 0;
        int n = chars.length;
        while (j < n) {
            while (j < n && chars[j] == ' ') j++; //skip spaces
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++]; //keep non spaces
            while (j < n && chars[j] == ' ') j++; // skip spaces
            if (j < n) chars[i++] = ' '; //keep only one space
        }
        return new String(chars).substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello   world  "));
    }
}
