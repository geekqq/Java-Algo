package Day230;

public class ReverseByEachWord {

    public static String reverseEachWord(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
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

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String s = "hello world";
        System.out.println(reverseEachWord(s));
    }
}
