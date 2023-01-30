package Day136;

public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;

        int[] increasingSeq = new int[len];
        int index = 0;
        increasingSeq[0] = nums[index++];

        for (int i = 1; i < len; i++) {
            if (nums[i] > increasingSeq[index - 1]) {
                increasingSeq[index++] = nums[i];
            } else {
                int pos = findPosition(increasingSeq, 0, index - 1, nums[i]);
                increasingSeq[pos] = nums[i];
            }
        }
        return index;
    }
    private static int findPosition(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 6, 7, 8, 9, 1, 2, 10, 3, 4, 12};
        System.out.println(longestIncreasingSubsequence(nums));
    }
}
