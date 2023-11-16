package Day327;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxSumWindow {

    public static int maxWindowSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int windowSum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < arr.length - k; end++) {
            windowSum += arr[end];
            if (end >= k - 1) {
                max = Math.max(max, windowSum);
                windowSum -= arr[start++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        System.out.println(maxWindowSum(arr, 3));
    }
}
