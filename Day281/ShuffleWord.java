package Day281;

import java.util.Arrays;
import java.util.Random;

import static Day281.ShuffleSentence.swap;

public class ShuffleWord {

    public static String shuffleWord(String word) {
        char[] chars = word.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(chars, i, j);
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(shuffleWord("stone"));
    }
}
