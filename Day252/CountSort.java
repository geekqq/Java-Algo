package Day252;

import java.util.Arrays;

public class CountSort {

    public static int[] countSort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] newArr = Arrays.copyOf(nums, nums.length);
        int max = Arrays.stream(newArr).max().getAsInt();
        int[] bucket = new int[max + 1];
        for (int value : newArr) {
            bucket[value]++;
        }
        int indexSorted = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                newArr[indexSorted++] = i;
                bucket[i]--;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4,2,2,3,5};
        System.out.println(Arrays.toString(countSort(nums)));
    }
}
