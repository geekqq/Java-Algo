package Day27;

import java.util.Arrays;

public class StringEquals {
    public static void main(String[] args) {
        String s1 = "hello!";
        String s2 = new String("hello!");
        System.out.println(isReverseString(s1, s2));
        System.out.println(Arrays.equals(s1.toCharArray(), s2.toCharArray()));
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }

    public static boolean isReverseString(String s1, String s2) {
        char[] charsS1 = s1.toCharArray();
        char[] charsS2 = s2.toCharArray();
        for (int i = 0, j = s1.length() - 1; i < j; i++, j--) {
            char temp = charsS1[i];
            charsS1[i] = charsS1[j];
            charsS1[j] = temp;
        }
        if (Arrays.equals(charsS1, charsS2)) {
            return true;
        }
        return false;
    }
}
