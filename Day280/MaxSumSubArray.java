package Day280;

public class MaxSumSubArray {

    public static int maxSumSubArray(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int maxSoFar = arr[0];
        int curMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curMax = Math.max(curMax + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, -2, 4, 6, -12, 7, -1, 6};
        System.out.println(maxSumSubArray(arr));
    }
}
