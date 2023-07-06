package Day253;

public class SearchInRotatedArrayWithDuplicates {
    public static boolean searchRotatedArray(int[] nums, int t) {
        int n = nums.length;
        int R = n - 1;
        while (R > 0 && nums[R] == nums[0]) R--;
        if (R == 0) return nums[0] == t;

        int l = 0;
        int r = R;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (nums[m] >= nums[0]) l = m;
            else r = m - 1;
        }

        if (t >= nums[0]) {
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

    public static boolean searchII(int[] nums, int t) {
        int n = nums.length;
        int R = n - 1;
        while (R > 0 && nums[R] == nums[0]) R--;
        if (R == 0) return nums[0] == t;

        int l = 0;
        int r = R;
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] >= nums[0] && t >= nums[0]
            || nums[m] < nums[0] && t < nums[0]) {
                if (nums[m] >= t) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] >= nums[0]) { //mid at left half, t at right half
                l = m + 1;
            } else { // mid is at right half, t at left half
                r = m - 1;
            }
        }
        return nums[r] == t;
    }

    public static boolean searchIII(int[] nums, int t) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == t;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + r >> 1;
            if (nums[l] == t) return true;
            if (nums[r] == t) return true;
            if (nums[m] == t) return true;
            if (nums[l] == nums[m]) l++;
            else if (nums[m] == nums[r]) r--;
            else if (nums[l] < nums[m]) {
                if (nums[l] < t && t < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < t && t < nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,6,0,0,0,1,1,2};
        int target = 8;
        System.out.println(searchRotatedArray(nums, target));
        System.out.println("--------");
        for (int i = -2; i < 10; i++) {
            System.out.println(i + " is in the array? " + searchRotatedArray(nums, i));
        }
        System.out.println("---------");
        for (int i = -2; i < 10; i++) {
            System.out.println(i + " is in the array? " + searchII(nums, i));
        }
        System.out.println("---------");
        for (int i = -2; i < 10; i++) {
            System.out.println(i + " is in the array? " + searchIII(nums, i));
        }
    }
}
