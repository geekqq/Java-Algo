package Day281;

import java.util.Random;

public class ShuffleSentence {

    public static String shuffleSentence(String s) {
        if (s == null || s.length() == 0) return null;
        String[] words = s.split(" ");
        shuffleStringArray(words);
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            char[] charArr = word.toCharArray();
            shuffleCharArray(charArr);
            word = String.valueOf(charArr);
            sb.append(word + " ");
        }
        return sb.toString().trim();
    }

    public static void shuffleStringArray(String[] words) {
        for (int i = words.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(words, i, j);
        }
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shuffleCharArray(char[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(arr, i, j);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(shuffleSentence("what are you doing?"));
    }
}
