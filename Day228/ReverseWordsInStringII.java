package Day228;

import static Day173.ReverseString.swap;

public class ReverseWordsInStringII {

    public static void reverseWords(char[] str) {
        if (str == null || str.length == 0) return;
        reverseArr(str);
        reverseEachWordI(str);
    }

    private static void reverseArr(char[] str) {
        int left = 0;
        int right = str.length - 1;
        while (left < right) {
            swap(str, left++, right--);
        }
    }
    private static void reverseEachWord(char[] str) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                int j = i + 1;
                while (j < str.length && str[j] != ' ') {
                    j++;
                }
                int left = i;
                int right = j - 1;
                while (left < right) {
                    swap(str, left++, right--);
                }
                i = j;
            }
        }
    }

    private static void reverseEachWordI(char[] str) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') continue;
            int j = i + 1;
            while (j < str.length && str[j] != ' ') {
                j++;
            }
            int left = i;
            int right = j - 1;
            while (left < right) {
                swap(str, left++, right--);
            }
            i = j;
        }
    }

    public static void main(String[] args) {
        char[] str = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(str);
        System.out.println(str);
    }
}
