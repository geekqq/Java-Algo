package Day26;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,8,9,11};
        int target = 0;
        System.out.println(getIndexOfTarget(nums, target));
    }

    public static int getIndexOfTarget(int[] nums, int n) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == n) return mid;
            else if (nums[mid] < n) left = mid + 1;
            else right = mid - 1;
            }
        return -1;
    }

}

