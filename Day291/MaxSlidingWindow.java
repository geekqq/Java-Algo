package Day291;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxSlidingWindow {

    public static int maxWindowSum(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) throw new IllegalArgumentException();
        int maxSum = Integer.MIN_VALUE;
        int maxSumWindow = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            maxSumWindow += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, maxSumWindow);
                maxSumWindow -= arr[start++];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 15);
        printArray(arr);
        System.out.println(maxWindowSum(arr, 3));
    }
}
