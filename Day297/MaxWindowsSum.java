package Day297;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxWindowsSum {

    public static int maxWindowSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int maxWindow = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            maxWindow += arr[end];
            if (end >= k - 1) {
                max = Math.max(max, maxWindow);
                maxWindow -= arr[start++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        System.out.println(maxWindowSum(arr, 3));
    }
}
