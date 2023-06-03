package Day236;

import java.util.Arrays;
import java.util.Random;

public class CreateRandomArrayWithoutDuplicates {

    //use this method to generate a random int array without duplicated elements
    public static int[] createRandomArray(int size, int min, int max) {
        if (size > max - min + 1 ) {
            throw new IllegalArgumentException();
            // in this case, the size is larger than the possible element,
            // so it is impossible to have unique element.
        }

        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        int index = 0;
        Arrays.fill(used, false);
        Random rand = new Random();
        while (index < size) {
            int randomNumber = rand.nextInt(max - min + 1) + min;
            if (!used[randomNumber - min]) {  // 转换成0 base的index
                arr[index++] = randomNumber;
                used[randomNumber - min] = true;
            }
        }
        return arr;
    }

    // test
    public static void main(String[] args) {
       int[] nums = createRandomArray(10, 5, 20);
        System.out.println(Arrays.toString(nums));
    }
}
