package Day210;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class CountSort {

    public static int[] countSort(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] newArr = Arrays.copyOf(nums, nums.length);
        int len = Arrays.stream(newArr).max().getAsInt() + 1;
        int[] bucket = new int[len];
        for (int value : newArr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int i = 0; i < len; i++) {
            while (bucket[i] > 0) {
                newArr[sortedIndex++] = i;
                bucket[i]--;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(18, 10);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(countSort(nums)));
    }
}
