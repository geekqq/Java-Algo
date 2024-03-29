package Day254;

public class SearchTargetInRotatedArray {

    public static boolean search(int[] nums, int t) {
        int n = nums.length;
        int R = n - 1;
        while (R > 0 && nums[R] == nums[0]) R--;
        if (R == 0) return nums[0] == t;

        int l = 0;
        int r = R;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (nums[m] >= nums[0]) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        if (t >= nums[0]) {
            l = 0;
        } else {
            r = R;
            l = l + 1;
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

    public static boolean searchII(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        while (r > 0 && nums[r] == nums[0]) r--;
        if (r == 0) return nums[0] == t;

        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] >= nums[0] && t >= nums[0]
            || nums[m] < nums[0] && t < nums[0]) {
                if (nums[m] >= t) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] >= nums[0]) {// m at left t at right
                l = m + 1;
            } else { // m at right t at left
                r = m - 1;
            }
        }
        return nums[r] == t;
    }

    public static boolean searchIII(int[] nums, int t) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == t;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (nums[left] == t) return true;
            if (nums[mid] == t) return true;
            if (nums[right] == t) return true;
            if (nums[left] == nums[mid]) left++;
            else if (nums[right] == nums[mid]) right--;
            else if (nums[mid] > nums[left]) {
                if (t >= nums[left] && t <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (t >= nums[mid] && t <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,7,0,0,1,1,2,3,3,4,4,4};
        for (int i = -3; i < 11; i++) {
            System.out.println("is " + i + " in the array ? " + searchIII(nums, i));
        }
    }
}
