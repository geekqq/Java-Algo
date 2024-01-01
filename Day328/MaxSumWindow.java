package Day328;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxSumWindow {

    public static int maxSumWin(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("invalid input!");
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < arr.length - k; end++) {
            sum += arr[end];
            if (end >= k - 1) {
                max = Math.max(sum, max);
                sum -= arr[start++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        System.out.println(maxSumWin(arr, 3));
    }
}
