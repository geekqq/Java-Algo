package Day137;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 0, 4, 3, 5};
        System.out.println(Arrays.toString(countSort(nums)));
    }
    private static int[] countSort(int[] nums) {
        int[] newArr = Arrays.copyOf(nums, nums.length);
        int max = Arrays.stream(newArr).max().getAsInt();
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];

        for (int value : newArr) {
            bucket[value]++;
        }

        int sortIndex = 0;
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0) {
                newArr[sortIndex++] = i;
                bucket[i]--;
            }
        }
        return newArr;
    }
}
