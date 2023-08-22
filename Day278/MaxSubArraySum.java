package Day278;

public class MaxSubArraySum {

    public static int getMaxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int maxSoFar = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum = Math.max(maxSum + arr[i], arr[i]);
            maxSoFar = Math.max(maxSum, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, -2, 4, 6, -12, 7, -1, 6};
        System.out.println(getMaxSubArraySum(arr));
    }
}
