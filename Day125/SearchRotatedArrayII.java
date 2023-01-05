package Day125;

//leetcode 81 duplicated elements
public class SearchRotatedArrayII {
    public static void main(String[] args) {
        int[] nums = {5,5,6,6,7,7,8,8,1,1,1,1,2,2,3,4};
        int target = 0;
        System.out.println(searchRotatedArray(nums, target));
    }

    public static boolean searchRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return  false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target) return true;
            if (nums[mid] == target) return true;
            if (nums[right] == target) return true;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[left] < nums[mid]) {
                if (nums[left] < target && target <nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return  false;
    }
}
