package Day168;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = randomArray(10,10);
        System.out.println(Arrays.toString(nums));
        System.out.println(getLIS(nums));
    }

    private static int getLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] increasingSeq = new int[len];
        int index = 0;
        increasingSeq[0] = nums[index++];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > increasingSeq[index - 1]) {
                increasingSeq[index++] = nums[i];
            } else {
                int pos = findInsertPos(increasingSeq, 0, index - 1, nums[i]);
                increasingSeq[pos] = nums[i];
            }
        }
        return index;
    }

    private static int findInsertPos(int[] nums, int left, int right, int x) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == x) return mid;
            else if (nums[mid] < x) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

}
