package Day137;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,180};
        System.out.println(lengthOfLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] increasingSeq = new int[len];

        int index = 0;
        increasingSeq[0] = nums[index++];
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                increasingSeq[index++] = nums[i];
            } else {
                int pos = findInsertPos(increasingSeq, 0, index - 1, nums[i]);
                increasingSeq[pos] = nums[i];
            }
        }
        return index;
    }

    private static int findInsertPos(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
