package Day19;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9};
        int target = 9;
        System.out.println(getIndex(nums, target));
    }

    public static int getIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return mid;
    }
}
