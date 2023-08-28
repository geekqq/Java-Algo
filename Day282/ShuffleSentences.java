package Day282;

import java.util.Random;

import static Day281.ShuffleSentence.swap;

public class ShuffleSentences {

    public static String shuffleSentence(String s) {
        String[] words = s.split(" ");
        shuffleWords(words);
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            char[] chars = word.toCharArray();
            shuffleWord(chars);
            sb.append(String.valueOf(chars) + " ");
        }
        return sb.toString().trim();
    }

    public static void shuffleWords(String[] words) {
        for (int i = words.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(words, i, j);
        }
    }
    public static void shuffleWord(char[] chars) {
        for (int i = chars.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(chars, i, j);
        }
    }

    public static void main(String[] args) {
        System.out.println(shuffleSentence("how are you doing today"));
    }
}
