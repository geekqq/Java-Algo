package Day51;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,3,5,7,8};
        int t = 8;
        System.out.println(binarySearch(nums, t));
    }

    public static int binarySearch(int[] nums, int target) {
        //corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;//Integer overflow
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
