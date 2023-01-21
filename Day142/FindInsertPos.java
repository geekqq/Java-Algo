package Day142;

public class FindInsertPos {
    public static void main(String[] args) {
        int[] nums = {2,4,5,6,7,9};
        System.out.println(findInsertPos(nums, 2));
    }

    private static int findInsertPos(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid +1;
            else right = mid - 1;
        }
        return left;
    }
}
