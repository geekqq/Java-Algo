package Day280;

import static Day280.ShuffleArray.shuffleArray;

public class ShuffleSentence {

    public static void shuffleSentence(String sentence) {
        if (sentence == null || sentence.length() == 0) throw new IllegalArgumentException("invalid input!");
        String[] words = sentence.split(" ");
        shuffleArray(words);
        for (String word : words) {
            Character[] characterArray = new Character[word.length()];
            for (int i = 0; i < word.length(); i++) {
                characterArray[i] = word.charAt(i);
            }
            shuffleArray(characterArray);
        }
    }

    public static void main(String[] args) {
        shuffleSentence("thi is a test case");

    }
}
