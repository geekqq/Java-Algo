package Day38;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,8,9,};
        int target = 1;
        System.out.println(binarySearch(nums, target));
    }
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
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
