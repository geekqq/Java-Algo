package Day267;

import static Day267.RandomizeWord.randomizeWord;

public class RandomSentence {

    public static String randomSentence(String s) {
        if (s == null || s.length() == 0) return null;
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(randomizeWord(word) + " ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(randomSentence("to make our operator safer"));
    }
}
