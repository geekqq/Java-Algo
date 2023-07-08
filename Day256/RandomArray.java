package Day256;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {

    public static int[] randomArray(int size, int max) {
        int[] arr = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            int num = rd.nextInt(max + 1); //generate random num from 0 to max;
            arr[i] = num;
        }
        return arr;
    }

    public static void main(String[] args) {
        //int[] num = randomArray(10, 15);
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println(Arrays.toString(randomArray(10, 15)));
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
        System.out.println(Arrays.toString(generateRandomArrayWithNoDuplicates(10, 10, 20)));
    }

    public static int[] generateRandomArrayWithNoDuplicates(int size, int min, int max) {
        if (max - min + 1 < size) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        int index = 0;
        Random rd = new Random();
        while (index < size) {
            int num = rd.nextInt(max - min + 1) + min;
            if (!used[num - min]) {
                arr[index++] = num;
                used[num - min] = true;
            }
        }
        return arr;
    }

}
