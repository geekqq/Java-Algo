package Day124;

public class SearchRotatedArrayII {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,5,5,0,1,2};
        int t = 7;
        System.out.println(searchRotatedArray(nums, t));

    }
    public static boolean searchRotatedArray(int[] nums, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == t) {
                return true;
            }
            if (nums[mid] == t) {
                return true;
            }
            if (nums[right] == t) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[left] < nums[mid]) {
                if (t > nums[left] && t < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (t > nums[mid] && t < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
