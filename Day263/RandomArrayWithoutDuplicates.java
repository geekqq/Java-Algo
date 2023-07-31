package Day263;

import java.util.Arrays;
import java.util.Random;

public class RandomArrayWithoutDuplicates {

    public static int[] randomArrayWithoutDuplicates(int size, int min, int max) {
        if (max - min + 1 < size) throw new IllegalArgumentException();
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomArrayWithoutDuplicates(12, 8, 20)));
    }
}
