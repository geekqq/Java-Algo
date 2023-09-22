package Day304;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxWindowSum {

    public static int maxWindowSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int windowSum = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if (i >= k - 1) {
                max = Math.max(max, windowSum);
                windowSum -= arr[start++];
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
