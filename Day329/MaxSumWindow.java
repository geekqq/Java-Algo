package Day329;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxSumWindow {

    public static int maxSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Invalid input!");
        int max = Integer.MIN_VALUE;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            if (end >= k - 1) {
                max = Math.max(max, sum);
                sum -= arr[start++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 25);
        printArray(arr);
        System.out.println(maxSum(arr, 3));
    }
}
