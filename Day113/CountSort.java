package Day113;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {1,4,0,2,7,3,2,5,0,9};
        System.out.println(Arrays.toString(countSort(nums)));
    }
    public static int[] countSort(int[] nums) {
        if (nums == null | nums.length == 0) {
            return null;
        }
        int[] newNums = Arrays.copyOf(nums, nums.length);
        int max = Arrays.stream(newNums).max().getAsInt();
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];
        for (int value : newNums) {
            bucket[value] ++;
        }
        int indexSorted = 0;
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0) {
                newNums[indexSorted++] = i;
                bucket[i]--;
            }
        }
        return newNums;
    }
}
