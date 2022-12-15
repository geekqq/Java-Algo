package Day105;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {1,4,1,2,7,5,9};
        System.out.println(Arrays.toString(sort(arr)));
    }
    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = Arrays.stream(arr).max().getAsInt();
        return countingSort(arr, maxValue);
    }
    public static int[] countingSort(int[] arr, int maxValue) {
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
}
