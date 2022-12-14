package Day104;

import java.util.Arrays;

public class CountingSort {
    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = Arrays.stream(arr).max().getAsInt();
        return countingSort(arr, maxValue);
    }
    private static int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,1,2,7,5,9};
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int bucketLen = maxValue + 1;
        System.out.println(bucketLen);
        int[] bucket = new int[bucketLen];
        for (int value : nums) {
            bucket[value]++;
        }
        System.out.println(Arrays.toString(bucket));
        System.out.println(Arrays.toString(sort(nums)));
    }
}
