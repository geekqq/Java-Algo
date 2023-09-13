package Day294;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxSumWindow {

    public static int maxSumWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw  new IllegalArgumentException("Invalid input!");
        int start = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxWinSum = 0;
        for (int end = 0; end < arr.length; end++) {
            maxWinSum += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, maxWinSum);
                maxWinSum -= arr[start++];
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
