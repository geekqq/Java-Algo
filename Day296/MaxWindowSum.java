package Day296;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxWindowSum {

    public static int maxWindowSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int maxSum = Integer.MIN_VALUE;
        int maxWindowSum = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            maxWindowSum += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, maxWindowSum);
                maxWindowSum -= arr[start++];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        System.out.println(maxWindowSum(arr, 3));
    }
}
