package Day267;

import java.util.Random;

public class RandomizeWord {
    public static String randomizeWord(String s) {
        if (s == null || s.length() == 0) return null;
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[chars.length];
        Random rd = new Random();
        int index = 0;
        while (index < chars.length) {
            int num = rd.nextInt(chars.length);
            if (!used[num]) {
                chars[index++] = s.charAt(num);
                used[num] = true;
            }
        }
        return new String(chars);
    }

    public static String shuffleWord(String s) {
        if (s == null || s.length() == 0) return null;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(chars, i, j);
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    public static void main(String[] args) {
        System.out.println(randomizeWord("hello"));
        System.out.println(shuffleWord("hello"));
    }
}
