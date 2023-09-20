package Day302;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxWinSum {

    public static int maxWinSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int maxWin = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            maxWin += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, maxWin);
                maxWin -= arr[start++];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        System.out.println(maxWinSum(arr, 3));
    }
}
