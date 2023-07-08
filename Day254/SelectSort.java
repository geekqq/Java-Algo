package Day254;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static Day37.SortedArray.swap;

public class SelectSort {

    public static void selectSort(int[] nums) {
        //cc
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,3,5,2,7,23,12};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(generateRandomArrayWithoutDuplicates(10, 10, 20)));
    }

    public static int[] generateRandomArrayWithoutDuplicates(int size, int min, int max) {
        if (size > max - min) {
            throw new IllegalArgumentException();
        }
        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        int index = 0;
        Arrays.fill(used, false);
        Random rand = new Random();
        Set<Integer> set = new HashSet<>();
        while (index < size) {
            int num = rand.nextInt(max - min + 1) + min;
            if (!used[num - min]) {
                arr[index++] = num;
                used[num - min] = true;
            }
        }
        return arr;
    }
}
