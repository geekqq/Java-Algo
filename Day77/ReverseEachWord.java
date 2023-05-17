package Day77;

import Day23.IsWanshu;

import static Day173.ReverseString.swap;

public class ReverseEachWord {

    public static String reverseEachWord(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
             else {
                int j = i + 1;
                while (j < chars.length && j != ' ') {
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

    public static String clearSpaces(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
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
        String s = "hello world !";
        String str = clearSpaces(s);
        System.out.println(reverseEachWord(str));
        System.out.println(reverseByWord(s));
    }

    public static String reverseByWord(String s) {
        if (s == null || s.length() == 0) return s;

        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left < right) {
                swap(chars, left++, right--);
            }
            words[i] = new String(chars);
        }
        return String.join(" ", words);
    }
}
