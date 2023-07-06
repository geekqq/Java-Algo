package Day254;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomArrayWithNoDuplicates {

    public static void generateRandomArrayWithoutDuplicates(int size, int min, int max) {
        if (size > max - min) {
            throw new IllegalArgumentException();
        }
        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        int index = 0;
        Random rand = new Random();
        while (index < size) {
            int num = rand.nextInt(max - min + 1) + min;
            if (!used[num - min]) {
                arr[index++] = num;
                used[num - min] = true;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        generateRandomArrayWithoutDuplicates(10, 10, 20);
        generateRandomArrayWithoutDuplicates(10, 10, 20);
        generateRandomArrayWithoutDuplicates(10, 10, 20);
        generateRandomArrayWithoutDuplicates(10, 10, 20);
        generateRandomArrayWithoutDuplicates(10, 10, 20);
    }
}
