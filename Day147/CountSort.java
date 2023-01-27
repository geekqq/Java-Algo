package Day147;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = randomArray(10, 10);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(countSort(nums)));
    }

    private static int[] countSort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
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
