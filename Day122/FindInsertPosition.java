package Day122;

public class FindInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,8};
        int target = 0;
        System.out.println(findInsertPosition(nums, target));
    }
    public static int findInsertPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
