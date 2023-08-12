package Day270;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class shuffleArray {

    public static void shuffleArray(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(nums, i, j);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        printArray(arr);
        //shuffleArray(arr);
        List<int[]> list = Arrays.asList(arr);
        Collections.shuffle(list);
    }
}
