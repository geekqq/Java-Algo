package Day268;

import java.util.Random;


public class ShuffleList {


    public static String shuffleSentence(String s) {
        //cc
        String[] words = s.split(" ");
        shuffleWordArray(words);
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            String newWord = shuffleWord(word);
            sb.append( newWord + " ");
        }
        return sb.toString().trim();
    }

    private static void shuffleWordArray(String[] strArr) {
        for (int i = strArr.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(strArr, i, j);
        }
    }

    private static String shuffleWord(String s) {
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(chars, i, j);
        }
        return new String(chars);
    }

    private static void swap( String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {

        System.out.println(shuffleSentence("I love your mon haha?"));
    }
}
