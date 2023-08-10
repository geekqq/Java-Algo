package Day267;

import static Day263.ReverseString.swap;

public class ReverseSentenceByWord {

    public static String reverseSentence(String s) {
        if (s == null || s.length() == 0) return null;
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(reverseWord(word) + " ");
        }
        return res.toString().trim();
    }

    private static String reverseWord(String word) {

        if (word == null || word.length() == 0) return null;

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            swap(chars, i, chars.length - 1 - i);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseWord("hello"));
        System.out.println(reverseSentence("I love new york"));
    }
}
