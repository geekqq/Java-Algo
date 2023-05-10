package Day227;

import static Day173.ReverseString.swap;

public class ReverseWordInString {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        //String str = clearExtraSpaces(s);
        String reversedStr = reverse(s);
        String words = reverseEachWord(reversedStr);
        return cleanSpace(words.toCharArray());
    }

    private static String clearExtraSpaces(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() && s.charAt(left) == ' ') left++;
        while (right >= 0 && s.charAt(right) == ' ') right--;
        if (left > right) return "";
        return s.substring(left, right + 1);
    }

    private static String reverse(String s) {
        if (s.length() == 0) return "";
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            swap(chars, left++, right--);
        }
        return new String(chars);
    }

    private static String reverseEachWord(String s) {
        if (s.length() == 0) return "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] ==' ') continue;
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
    private static String cleanSpace(char[] chars) {
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
        String s = "  hello  world   !   ";
//        System.out.println(clearExtraSpaces(s));
//        System.out.println(reverse(s));
//        System.out.println(reverseEachWord(reverse(s)));
        //System.out.println(cleanSpace(s.toCharArray()));
        System.out.println(reverseWords(s));
    }
}
