package Day306;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxWindowSum {

    public static int maxWinSum(int[] arr, int k) {
        int start = 0;
        int maxWin = 0;
        int max = Integer.MIN_VALUE;
        for (int end = 0; end < arr.length; end++) {
            maxWin += arr[end];
            if (end >= k - 1) {
                max = Math.max(max, maxWin);
                maxWin -= arr[start++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        System.out.println(maxWinSum(arr, 3));
    }
}
