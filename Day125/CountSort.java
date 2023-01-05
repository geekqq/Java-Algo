package Day125;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {1,0,1,4,3,5,2,0};
        System.out.println(Arrays.toString(countSort(nums)));

    }
    public static int[] countSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] newArr = Arrays.copyOf(nums, nums.length);
        int max = Arrays.stream(newArr).max().getAsInt();
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];
        for (int value : newArr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0) {
                newArr[sortedIndex++] = i;
                bucket[i]--;
            }
        }
        return newArr;
    }
}
