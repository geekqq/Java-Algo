package Day292;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxSumWindow {

    public static int maxSumWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        int maxWindow = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            maxWindow += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, maxWindow);
                maxWindow -= arr[start++];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        System.out.println(maxSumWindow(arr, 3));
    }
}
