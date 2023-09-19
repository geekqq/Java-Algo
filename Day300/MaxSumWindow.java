package Day300;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxSumWindow {

    public static int maxSumWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
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
        System.out.println(maxSumWindow(arr, 3));
    }
}
