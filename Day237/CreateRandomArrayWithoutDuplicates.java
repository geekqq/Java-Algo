package Day237;

import java.util.Arrays;
import java.util.Random;

public class CreateRandomArrayWithoutDuplicates {

    public static int[] createRandomArray(int size, int min,int max) {
        if (size > max - min + 1) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        Arrays.fill(used, false);
        int index = 0;
        Random rand = new Random();
        for (int i = index; i < size; i++) {
            int randNum = rand.nextInt(max - min + 1) + min;
            if (!used[randNum - min]) {
                arr[index++] = randNum;
                used[randNum - min] = true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int size = 6;
        System.out.println(Arrays.toString(createRandomArray(size, 5, 21)));
    }

}
