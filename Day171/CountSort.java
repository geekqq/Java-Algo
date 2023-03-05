package Day171;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = randomArray(10,10);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {8, 2, 0, 8, 7, 2, 0, 4, 3, 6};
        System.out.println(Arrays.toString(countSort(nums2)));
    }

    private static int[] countSort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] newArr = Arrays.copyOf(nums, nums.length);
        int max = Arrays.stream(newArr).max().getAsInt();
        int len = max + 1;
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
}
