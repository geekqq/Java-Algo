package Day313;

public class MinWindowSumGreater {

    public static int minWindowSumGreater(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int sum = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (start <= end && sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start++];
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        System.out.println(minWindowSumGreater(arr1, x));
    }
}
