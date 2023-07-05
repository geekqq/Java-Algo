package Day252;

public class SearchInRotatedSortedArray {
    public static boolean search(int[] nums, int t) {
        int n = nums.length;
        int R = n - 1;
        while (R > 0 && nums[R] == nums[0]) R--;
        if (R == 0) return nums[0] == t;

        int l = 0;
        int r = R;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }

        if (t >= nums[0]) l = 0;
        else {
            l = r + 1;
            r = R;
        }

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= t) r = mid;
            else {
                l = mid + 1;
            }
        }
        return nums[r] == t;
    }
    public static boolean searchII(int[] nums, int t) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (r > 0 && nums[r] == nums[0]) r--;
        if (r == 0) return nums[0] == t;

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= nums[0] && t >= nums[0] || nums[mid] < nums[0] && t < nums[0]) {
                if (nums[mid] >= t) r = mid;
                else  l = mid + 1;
            } else if (nums[mid] >= nums[0]) {
                    l = mid + 1;
            } else {
                r = mid - 1;
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
            int mid = left + (right - left) / 2;
            if (nums[left] == t) return true;
            if (nums[mid] == t) return true;
            if (nums[right] == t) return true;
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

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,6,0,0,0,1,1,2};
        int target = 8;
        System.out.println(search(nums, target));
        System.out.println(searchII(nums, target));
        System.out.println(searchIII(nums, target));
    }
}
