package Day124;

public class FindInsertIndex {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,6,8};
        int target = 5;
        System.out.println(findInsertIndex(nums, target));
    }
    public static int findInsertIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }
}
