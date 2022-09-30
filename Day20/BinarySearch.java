package Day20;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11};
        int target = 10;
        System.out.println(getIndex(nums, target));
    }

    public static int getIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;

        if (nums == null || nums.length == 0) return -1;

        while (left <= right) {
            mid = left + (right - left ) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return mid;
    }
}
