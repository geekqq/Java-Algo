package Day114;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {1,4,0,2,7,3,2,5,0,9};
        System.out.println(Arrays.toString(countSort(nums)));
    }
    public static int[] countSort(int[] nums) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        int max = Arrays.stream(nums).max().getAsInt();
        int bucketlen = max + 1;
        int[] bucket = new int[bucketlen];
        for (int value : newNums) {
            bucket[value]++;
        }
        int indexSorted = 0;
        for (int i = 0; i < bucketlen; i++) {
            while (bucket[i] > 0) {
                newNums[indexSorted++] = i;
                bucket[i]--;
            }
        }
        return newNums;
    }
}
