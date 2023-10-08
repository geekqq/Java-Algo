package Day318;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxWindowSum {

    public static int maxWindowSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int window = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            window += arr[end];
            if (end >= k - 1) {
                max = Math.max(max, window);
                window -= arr[start++];
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
