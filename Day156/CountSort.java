package Day156;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = randomArray(12,10);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(countSort(nums)));
    }
    private static int[] countSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] newArr = Arrays.copyOf(nums, nums.length);
        int len = Arrays.stream(newArr).max().getAsInt() + 1;
        int[] bucket = new int[len];
        for (int value : newArr) {
            bucket[value]++;
        }
        int indexSorted = 0;
        for (int i = 0; i < len; i++) {
            while (bucket[i] > 0) {
                newArr[indexSorted++] = i;
                bucket[i]--;
            }
        }
        return newArr;
    }
}
