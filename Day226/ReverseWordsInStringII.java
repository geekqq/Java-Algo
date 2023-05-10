package Day226;

public class ReverseWordsInStringII {

    public static void reverseWords(char[] str) {
        if (str == null || str.length == 0) return;

        reverseArr(str);
        reverseWord(str);
    }
    private static void reverseArr(char[] str) {
        int left = 0;
        int right = str.length - 1;
        while (left < right) {
            swap(str, left++, right--);
        }
    }
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    private static void reverseWord(char[] str) {
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

    public static void main(String[] args) {
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
        System.out.println(s);
    }
}
