package Day283;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxWindowSum {

    public static int maxWindowSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int windowSum = 0;
        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[start];
                start++;
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
