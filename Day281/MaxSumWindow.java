package Day281;

public class MaxSumWindow {

    public static int maxSumWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int start = 0;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,5,-7,6,1};
        System.out.println(maxSumWindow(arr, 3));
    }
}
