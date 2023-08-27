package Day280;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxWindowsSumArray {

    public static int findMaxWindowSumArray(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) throw new IllegalArgumentException();
        int maxSum = 0;
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
        int[] arr = randomArray(10, 20);
        printArray(arr);
        System.out.println(findMaxWindowSumArray(arr, 3));
    }
}
