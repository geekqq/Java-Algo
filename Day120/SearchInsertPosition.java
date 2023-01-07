package Day120;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1; //throw exception
        }
        int left = 0;
        int right = nums.length - 1;
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
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }
}
