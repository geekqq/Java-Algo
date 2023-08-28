package Day282;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxSumWindow {

    public static int maxSumWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int start = 0;
        int maxSum = Integer.MIN_VALUE;
        int sumWindow = 0;
        for (int end = 0; end <= arr.length - 1; end++) {
            sumWindow += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, sumWindow);
                sumWindow -= arr[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 15);
        printArray(arr);
        System.out.println(maxSumWindow(arr, 3));
    }
}
