package Day256;

public class SearchRotatedArrayWithDuplicates {

    public static boolean search(int[] nums, int t) {
        if (nums == null || nums.length == 0) return false;
        int l = 0;
        int R = nums.length - 1;
        while (R > 0 && nums[R] == nums[0]) R--;
        if (R == 0) return nums[0] == t;
        int r = R;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (nums[m] >= nums[0]) l = m;
            else r = m - 1;
        }

        if (nums[0] <= t) {
            l = 0;
        } else {
            l = r + 1;
            r = R;
        }
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[r] == t;
    }

    public static boolean searchI(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        while (r > 0 && nums[r] == nums[0]) r--;
        if (r == 0) return nums[0] == t;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (nums[m] >= nums[0] && t >= nums[0]
            || nums[m] < nums[0] && t < nums[0]) { // m and t are at same side
                if (nums[m] >= t) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] >= nums[0]) { //m at left, t at right
                l = m + 1;
            } else {//m at right, t at left
                r = m - 1;
            }
        }
        return nums[r] == t;
    }

    public static boolean searchII(int[] nums, int t) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == t) return true;
            if (nums[left] == t) return true;
            if (nums[right] == t) return true;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[mid] > nums[left]) {
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
    public static void main(String[] args) {
        int[] nums = {4,5,6,0,1,2,3,4,4};
        System.out.println(search(nums, 4));
        System.out.println(searchI(nums, 9));
        System.out.println(searchII(nums, 0));
    }
}
