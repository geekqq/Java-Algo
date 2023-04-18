package Day215;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class GetLIS {

    public static int getLIS(int[] nums) {
        int len = nums.length;
        int[] increasingSeq = new int[len];
        int index = 0;
        increasingSeq[0] = nums[index++];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > increasingSeq[index - 1]) {
                increasingSeq[index++] = nums[i];
            } else {
                int pos = findInsertPos(increasingSeq, 0, index, nums[i]);
                increasingSeq[pos] = nums[i];
            }
        }
        return index;
    }

    private static int findInsertPos(int[] nums, int left, int right, int target) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(15, 10);
        System.out.println(Arrays.toString(nums));
        System.out.println(getLIS(nums));
    }
}
