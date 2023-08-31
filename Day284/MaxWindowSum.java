package Day284;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxWindowSum {

    public static int getTheMaxSumWindow(int[] arr, int k) {
        if (arr == null | arr.length == 0) throw new IllegalArgumentException();
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int start = 0;
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
        int[] arr = randomArray(7, 15);
        printArray(arr);
        System.out.println(getTheMaxSumWindow(arr, 3));
    }
}
