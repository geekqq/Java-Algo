package Day120;

public class FindClosestToTarget {
    public static int findClosestIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //left is preferred if left and right both same distance to the target;
        return Math.abs(nums[left] - target) <= Math.abs(nums[right] - target) ? left : right;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int target = 10;
        System.out.println(findClosestIndex(nums, target));
    }
}
