package Day116;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,4,4,4,5,6,7,8,9,10};
        int[] nums2 = {40,20,40,50,50,10,30};

        System.out.println(Arrays.toString(countSort(nums)));
        System.out.println(Arrays.toString(countSort(nums2)));
    }
    public static int[] countSort(int[] nums) {
        if (nums == null || nums.length == 0) {
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
