package Day106;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {1,4,1,2,7,5,9};
        System.out.println(Arrays.toString(countSort(nums)));
    }
    public static int[] countSort(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        int max = Arrays.stream(newArr).max().getAsInt();
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];
        for (int value : newArr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                newArr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return newArr;
    }
}
