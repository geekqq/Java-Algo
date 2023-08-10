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

    public static void main(String[] args) {
        System.out.println(randomizeWord("hello"));
    }
}
