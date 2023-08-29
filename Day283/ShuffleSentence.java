package Day283;

import static Day282.ShuffleSentences.shuffleWord;
import static Day283.ShuffleArray.shuffleArray;

public class ShuffleSentence {

    public static String shuffleSentence(String s) {
        if (s == null || s.length() == 0) return null;
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        shuffleArray(words);
        for (String word : words) {
            char[] chars = word.toCharArray();
            shuffleWord(chars);
            word = String.valueOf(chars);
            sb.append(word + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(shuffleSentence("what you doing now?"));
    }
}
