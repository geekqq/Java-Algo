package Day271;

import java.util.Arrays;
import java.util.Random;

public class GenerateArrayWithoutDuplicates {

    public static int[] generateArrayWithoutDuplicates(int size, int min, int max) {
        if (max - min + 1 < size) {
            throw new IllegalArgumentException();
        }
        int[] arr = new int[size];
        boolean[] seen = new boolean[max - min + 1];
        Random rd = new Random();

        int index = 0;
        while (index < size) {
            int num = rd.nextInt(max - min + 1) + min;
            if (!seen[num - min]) {
                arr[index++] = num;
                seen[num - min] = true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = generateArrayWithoutDuplicates(10, 2, 12);
        System.out.println(Arrays.toString(arr));
    }
}
