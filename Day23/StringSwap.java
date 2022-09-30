package Day23;

import java.util.Arrays;

public class StringSwap {
    public static void main(String[] args) {
        String s = "Hello Jinwei";
        System.out.println(stringSwap(s));
        System.out.println(stringSwapTwo(s));
    }

    public static String stringSwap(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0 ; i--) {
            res += s.charAt(i);
        }
        return res;
    }

    public static char[] stringSwapTwo(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return chars;
    }
}
