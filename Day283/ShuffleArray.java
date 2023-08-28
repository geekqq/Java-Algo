package Day283;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    public static <T> void shuffleArray(T[] array) {
        Random rd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rd.nextInt(i);
            swap(array, i, j);
        }
    }

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        String[] strArr = {"I", "love", "hayward", "yes", "do", "know"};
        shuffleArray(strArr);
        Integer[] intArr = {1,2,3,4,5,6};
        shuffleArray(intArr);
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(intArr));
    }
}
